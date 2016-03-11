
var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var register = require('./register.js');

io.on('connection', function(socket){
  console.log('a user connected');
  socket.on('send Register Data', function(msg){
    register.storeData(msg);
    var result = register.sendReply();
    socket.emit('register reply',{
      result:'stored'
    });
  });
});
http.listen(3000, function(){
  console.log('listening on *:3000');
});