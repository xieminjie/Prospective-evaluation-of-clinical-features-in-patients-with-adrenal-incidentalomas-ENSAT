
$(document).ready(function(){
	sentCodeRequest();
});

var getCode = function(length){
	$.ajax({
            type: "GET",
            url: "/userCode",
            contentType: 'application/json',
            data:{length:length},
            success: function(r) {
            	alert("the code of user is: "+r);
            },
            error: function(r){
                console.log("error");
            }
    });
}
var sentCodeRequest = function(){
	var requestBtn = $('#sendRequest');
	requestBtn.click(function(){
		var length = $('#requestVal').val();
		if(length){
			getCode(length);
		}else{
			alert('please enter the length of code');
		}
	});
}