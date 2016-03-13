var mysql = require('mysql');
var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'xieminjie126',
  database: 'research'
});
connection.connect();
module.exports = {
	queryUser
};
function queryUser(userid){
	var query = connection.query('select * from user where iduser = ?',userid,function(err,result){
		console.log(query.sql);
		return result;
	});
};