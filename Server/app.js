var express = require('express');
var app = express();
var events = require('events');
var eventEmitter = new events.EventEmitter();
var mysql = require('mysql');
var bodyParser = require('body-parser');
//Customize modules
var dataProcessing = require("./dataProcessing.js");
var randomstring = require('randomstring');

app.use(express.static('views'));
app.use(bodyParser.json()); // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true })); // support encoded bodies


// Connect with database
var connection = mysql.createConnection({
	host: 'localhost',
	user: 'root',
	password: 'xieminjie126',
	database: 'research'
});
connection.connect();

app.get('/',function(req,res){
	res.sendFile(__dirname+'/views/html/dashboard.html');
});
app.get('/patient',function(req,res){
	res.sendFile(__dirname+'/views/html/patient.html');
})
app.get('/patientStatisitc',function(req,res){
	res.sendFile(__dirname+'/views/html/patientStastic.html')
});
app.get('/data',function(req,res){
	connection.query('SELECT * FROM research.record;',function(err,result){
		if(err) {
			console.log('err');
			throw err;
		}
		else {
			var data = dataProcessing.chartGraphdataProcessing(result);
			console.log(data);
			if(data!=null){
				console.log('sending');
				res.send(data);
			}
		}
	});
});
app.get('/userCode',function(req,res){
	var length = req.query['length'];
	if(length){
		var code = randomstring.generate(parseInt(length));
		res.send(code);
	}
;});
//app login route 
app.get('/login?',function(req,res){
	var userID = req.query['login'];
	if(userID!=null){
		connection.query('SELECT COUNT(iduser) as count from user where iduser = ?',userID,function(err,result){
			if(err) {
				console.log('err');
				throw err;
			}
			else {
				var ifAuth;
				var resultReply = {
					status:true,
					Authentication:result.length==0?ifAuth=false:ifAuth=true
				};
				var gsonData = JSON.stringify(resultReply);
				if(gsonData!=null){
					res.send(gsonData);
				}
			}
		});
	}
});
app.post('/register?',function(req,res){
	var msg = req.body;
	var query = connection.query('insert into user set ?',msg, function (err, result) {
		if (err) {
			console.error(err);
			return;
		}
		console.error(result);
	});
});
app.get('/comparison?',function(req,res){
	var msg = req.query['query'];
	console.log('query '+msg);
	connection.query('SELECT * FROM research.record;',function(err,result){
		if(err) {
				console.log('err');
				throw err;
			}
			else {
				var result = dataProcessing.chartGraphdataProcessing(result);
				var data = JSON.parse(result);
				var returnmsg = 'null';
				console.log("msg "+data);
				var hashtable = new Object();
				if(msg=='weightgain'){
					console.log("da"+data.weight_gain);
					returnmsg = data.weight_gain;
				}else if (msg=='palpitations'){
					returnmsg = data.palpitations;
				}else if(msg=='highBloodPressure'){
					returnmsg = data.high_blood_pressure
				}else if(msg=='muscleWeakness'){
					returnmsg = data.muscle_weakness;
				}else if(msg=='sweating'){
					returnmsg = data.sweating;
				}else if(msg=='flushing'){
					returnmsg = data.flushing;
				}else if(msg=='headache'){
					returnmsg = data.headache;
				}else if(msg=='chestPain'){
					returnmsg = data.chest_pain;
				}else if(msg=='backPain'){
					returnmsg = data.back_pain;
				}else if(msg=='bruising'){
					returnmsg = data.bruising;
				}else if(msg=='fatigue'){
					returnmsg = data.fatigue;
				}else if(msg=='panic'){
					returnmsg = data.panic;
				}else if(msg=='sadness'){
					returnmsg = data.sadness;
				}else{
					returnmsg = 'null';
				}
				if(returnmsg!=null){
					var resultReply = {
						status:true,
						comparisonResult:returnmsg
					};
					var gsonData = JSON.stringify(resultReply);
					if(gsonData!=null){
						res.send(gsonData);
					}
				}
			}
	 });
});

app.post('/survey',function(req,res){
	var message = req.body;
	var query = connection.query('insert into record set ?',message, function (err, result) {
		if (err) {
			console.error(err);
			return;
		}
		console.error(result);
	});
});
app.get('/genderStastic?',function(req,res){
	var gender = req.query['gender'];
	var male = null;
	var female = null;
	var queryMale = connection.query('SELECT COUNT(iduser) as count from user where sex = ?','female',function(err,result){
			if(err) {
				console.log('err');
				throw err;
			}
			else {
				female = result[0].count;
					var queryMale = connection.query('SELECT COUNT(iduser) as count from user where sex = ?','male',function(err,result){
						if(err) {
							console.log('err');
							throw err;
						}
						else {
							male = result[0].count;
							var reply = {
								male:male,
								female:female
							}
							var msg = JSON.stringify(reply);
							res.send(msg);
						}
				});
			}
	});
});

app.get('/ageStastic?',function(req,res){});


app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});