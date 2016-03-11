var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

module.exports = {
  checkUser,
  sendReply
};

function checkUser(msg){
  var message = JSON.parse(msg);
  var userid = msg.userid;
  console.log(userid);
}
function sendReply(){
  return true;
}