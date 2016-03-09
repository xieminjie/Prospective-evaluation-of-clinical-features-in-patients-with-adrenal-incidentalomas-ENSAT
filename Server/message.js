module.exports = Message;
function Message(message){
	this.message = message;
}
Message.prototype.getMessage = function(){
	return message;
}
Message.prototype.setMessage = function(message){
	this.message = message;
}