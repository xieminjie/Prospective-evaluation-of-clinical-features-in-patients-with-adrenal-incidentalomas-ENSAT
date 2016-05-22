
var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var events = require('events');
var eventEmitter = new events.EventEmitter();
var mysql = require('mysql');
//Customize modules
var dataProcessing = require("./dataProcessing.js");
var randomstring = require('randomstring');


app.use(express.static('views'));

var connection = mysql.createConnection({
	host: 'localhost',
	user: 'root',
	password: 'xieminjie126',
	database: 'research'
});
connection.connect();

app.get('/',function(req,res){
	res.sendFile(__dirname+'/views/html/index.html');
});


io.on('connection', function(socket){

	socket.on('request code',function(msg){
		console.log('request code '+msg);
		io.emit('receive code',randomstring.generate(parseInt(msg)));
	});
	
	//console.log('a user connected');
	socket.on('send login request', function(msg){
		eventEmitter.emit('user query from database',msg);    
	});
	socket.on('single data request',function(msg){
	  eventEmitter.emit('single query from database',msg);
	});
	socket.on('send question Data',function(msg){
		var message = JSON.parse(msg);
		var query = connection.query('insert into record set ?',message, function (err, result) {
			 if (err) {
				 console.error(err);
				 return;
			 }
		console.error(result);
		});
	});
	
	socket.on('doc search',function(msg){
		console.log("doc: "+msg);
		eventEmitter.emit('overall query from database',msg);
	});
	eventEmitter.on('ready to reply',function(resultReply){
		console.log('ready to send',resultReply.userNum);
		socket.emit('login reply',resultReply);
	});
	eventEmitter.on('reply Doc',function(result){
		io.emit('receive overall search',result);
	});
	eventEmitter.on('single data',function(result){
		console.log("reply single data "+result);
		io.emit('reply single data',result);

	});

});


// query from user
eventEmitter.on('user query from database',function(msg){
	connection.query('SELECT COUNT(iduser) as count from user where iduser = ?',msg,function(err,result){
		if(err) {
			console.log('err');
			throw err;
		}
		else {
			console.log('length'+result.length);
			var resultReply = {
				userNum:result[0].count
			};
			eventEmitter.emit('ready to reply',resultReply);
		}
	 });
});


eventEmitter.on('single query from database',function(msg){
	console.log("calling database");
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
				eventEmitter.emit("single data",returnmsg);
			}
	 });
});




// query overall average data
eventEmitter.on('overall query from database',function(msg){
	connection.query('SELECT * FROM research.record;',function(err,result){
		if(err) {
			console.log('err');
			throw err;
		}
		else {
			eventEmitter.emit('chartGraphdataProcessing',result);
		}
	});
});

eventEmitter.on('chartGraphdataProcessing',function(result){
	var msg = dataProcessing.chartGraphdataProcessing(result);
	console.log(msg);
	eventEmitter.emit('reply Doc',msg);
});

http.listen(3000,function(){
	console.log('listening on *:3000');
});