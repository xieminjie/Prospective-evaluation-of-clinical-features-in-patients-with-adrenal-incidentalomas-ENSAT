var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

module.exports = {
  checkUser,
  sendReply
};

function checkUser(msg){
  console.log(msg);
}
function sendReply(){
  return true;
}