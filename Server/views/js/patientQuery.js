$(document).ready(function(){
	patientQuery();
});
var patientQuery = function(){
	var queryBtn = $('#patientQueryBtn');
	var queryInput = $('#iduserinput');
    queryBtn.click(function(){
        var iduser = queryInput.val();
        downloadPatientData(iduser); 
        downloadRecordData(iduser);
    });

}
var downloadPatientData = function(iduser){
    $.ajax({
            type: "GET",
            url: '/singlePatientDataQuery?',
            contentType: 'application/json',
            data:{
                iduser:iduser,
            },
            success: function(r) {
                var title = iduser+" Overal Data";
                processData(r,title);
            },
            error: function(r){
                console.log("error");
            }
    });
}
var downloadRecordData = function(iduser){
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
var processData= function(msg,title){
    console.log('processData');
    var title = title;
    var ytitle = 'point';
    var categoriesArray = ['weight_gain','palpitations','muscle_weakness',
        'sweating','flushing','headache','chest_pain','back_pain','bruising',
        'fatigue','panic','sadness'];
    var data = JSON.parse(msg);
    var dataArray =  [data.weight_gain,data.palpitations,data.muscle_weakness,data.sweating,
    data.flushing,data.headache,data.chest_pain,data.back_pain,data.bruising,data.fatigue,
    data.panic,data.sadness];
    var aName = 'Patient data';
    var value = [{
        name: aName,
        data: dataArray
    }];
    renderBarChart(categoriesArray,value,title,ytitle);
}

var renderBarChart = function (categoriesArray,value,title,ytitle){
    $('#patientIndividual').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: title
        },
        xAxis: {
            categories: categoriesArray
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        series: value
    });
}