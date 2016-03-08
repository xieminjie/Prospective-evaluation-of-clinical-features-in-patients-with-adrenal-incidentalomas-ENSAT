var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
io.on('connection', function(socket){
  console.log('a user connected');
  socket.on('sendRegisterData', function(msg){
  	var message = JSON.parse(msg);
  	var sex = message.sex;
  	var age = message.age;
  	var diagnosis = message.diagnosis;
  	console.log(msg);
  	console.log("sex: "+sex);
  	console.log("age: "+age);
  	console.log("diagnosis: "+diagnosis);
  });
});
http.listen(3000, function(){
  console.log('listening on *:3000');
});