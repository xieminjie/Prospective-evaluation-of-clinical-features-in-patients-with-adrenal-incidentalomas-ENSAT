
var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var events = require('events');
var eventEmitter = new events.EventEmitter();
var mysql = require('mysql');

var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'xieminjie126',
  database: 'research'
});
connection.connect();

io.on('connection', function(socket){
  console.log('a user connected');

  socket.on('send login request', function(msg){
    eventEmitter.emit('user query from database',msg);    
  });

  socket.on('send question Data',function(msg){
    console.log('receive question data');
    console.log(msg);
  });

});
eventEmitter.on('ready to reply',function(resultReply){
  console.log('ready to send',resultReply.userNum);
  socket.emit('login reply',resultReply);
});

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

http.listen(3000, function(){
  console.log('listening on *:3000');
});