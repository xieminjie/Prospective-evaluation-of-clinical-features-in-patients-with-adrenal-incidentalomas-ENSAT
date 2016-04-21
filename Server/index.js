
var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var events = require('events');
var eventEmitter = new events.EventEmitter();
var mysql = require('mysql');
//Customize modules
var dataProcessing = require("./dataProcessing.js");


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
  socket.on('send test msg',function(){
    console.log('test');
    socket.emit('reply test','helloworld');
  });


  //console.log('a user connected');
  socket.on('send login request', function(msg){
    eventEmitter.emit('user query from database',msg);    
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
    eventEmitter.emit('doc query from database',msg);
  });
  eventEmitter.on('ready to reply',function(resultReply){
    console.log('ready to send',resultReply.userNum);
    socket.emit('login reply',resultReply);
  });
  eventEmitter.on('reply Doc',function(result){
    io.emit('receive doc search',result);
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
      }
      eventEmitter.emit('ready to reply',resultReply);
    }
   });
});
// query from docs
eventEmitter.on('doc query from database',function(msg){
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