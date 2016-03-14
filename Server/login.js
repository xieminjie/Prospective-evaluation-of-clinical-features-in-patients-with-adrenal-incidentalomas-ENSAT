var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var events = require('events');
var mysql = require('mysql');
var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'xieminjie126',
  database: 'research'
});
connection.connect();
module.exports = {
  sendReply
};



function sendReply(loginRequest){
	console.log("loginRequest "+loginRequest);
	var userid = loginRequest;
	connection.query('select * from user where iduser = ?',userid,function(err,result){
		console.log(query.sql);
		if(err) throw err;
		else {
			console.log(result);
			return result;
		}
	});
}