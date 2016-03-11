
var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var login = require('./login.js');

io.on('connection', function(socket){
  console.log('a user connected');
  socket.on('send login request', function(msg){
    login.checkData(msg);
    var result = login.sendReply();
    socket.emit('register reply',{
      result:'stored'
    });
  });
});
http.listen(3000, function(){
  console.log('listening on *:3000');
});