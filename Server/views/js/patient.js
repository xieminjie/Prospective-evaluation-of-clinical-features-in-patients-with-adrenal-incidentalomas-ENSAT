
$(document).ready(function(){
	generateCode();
});
var getCode = function(length){
	$.ajax({
            type: "GET",
            url: "/userCode",
            contentType: 'application/json',
            data:{length:length},
            success: function(r) {
            	$('#codeText').val(r);
            },
            error: function(r){
                console.log("error");
            }
    });
}
var generateCode = function(){
	var codeBtn = $('#GenerateCode');
	codeBtn.click(function(){
		var length = $('#codeLengthInput').val();
		if(length){
			getCode(length);
		}else{
			alert('please enter the length of code');
		}
	});
}
var sendData = function(data){
	$.ajax({
            type: "POST",
            url: "/register",
            contentType: 'application/json',
            success: function(r) {
            	console.log(r);
            },
            error: function(r){
                console.log("error");
            }
    });
}
