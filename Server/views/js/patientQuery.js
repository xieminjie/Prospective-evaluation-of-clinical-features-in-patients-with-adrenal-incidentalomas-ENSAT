$(document).ready(function(){
	patientQuery();
});
var patientQuery = function(){
	var queryBtn = $('#patientQueryBtn');
	var queryInput = $('#iduserinput');
    queryBtn.click(function(){
        var iduser = queryInput.val();
        downloadPatientData(iduser); 
    });

}
var downloadPatientData = function(iduser){
	 $.ajax({
            type: "GET",
            url: '/singlePatientQuery?',
            contentType: 'application/json',
            data:{
            	iduser:iduser,
            },
            success: function(r) {
                addTable(r);
            },
            error: function(r){
                console.log("error");
            }
   		 });
}
var addTable = function(r){
    var tableDiv = $('#tableDiv');
    var userID = r[0].iduser;
    var age = r[0].age;
    var sex = r[0].sex;
    var diagnosis = r[0].diagnosis;
    tableDiv.fadeIn(500);
    $(".table").find('tbody')
    .append($('<tr>')
        .append($('<td>')
                .text(userID)
        )
        .append($('<td>')
                .text(age)
        )
        .append($('<td>')
                .text(sex)
        )
        .append($('<td>')
                .text(diagnosis)
        )
    );
}