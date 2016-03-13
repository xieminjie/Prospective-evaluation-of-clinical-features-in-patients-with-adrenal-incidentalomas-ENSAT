var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var events = require('events');

module.exports = {
  connectUser
};

function connectUser(){
   console.log('a user connected');
}

function 
socket.on('send login request', function(msg){
  //  socket.emit('login reply',login.sendReply(msg));
  });