var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var message = require('./message.js');

module.exports = {
  storeData,
  sendReply
};

function storeData(msg){
  var message = JSON.parse(msg);
  var sex = message.sex;
  var age = message.age;    
  var diagnosis = message.diagnosis;
  console.log(msg)
  console.log("se: "+sex);
  console.log("ae: "+age);
  console.log("diagnosis: "+diagnosis);
}
function sendReply(){
  return true;
}