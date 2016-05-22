
$(document).ready(function(){
	loadData();
	sentCodeRequest();
	//receiveData(socket);
	//var request = $('#requestVal').val();
	//socket.emit('doc search',request);

});
var loadData = function(){
	$.ajax({
            type: "GET",
            url: "/data",
            contentType: 'application/json',
            success: function(r) {
            	console.log(r);
            	processData(r);
            },
            error: function(r){
                console.log("error");
            }
    });
}
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
var processData= function(msg){
	var title = 'patientData';
	var ytitle = 'point';
	var categoriesArray = ['weight_gain','palpitations','muscle_weakness',
		'sweating','flushing','headache','chest_pain','back_pain','bruising',
		'fatigue','panic','sadness','body_hair_growth'];
	var data = JSON.parse(msg);
	var dataArray =  [data.weight_gain,data.palpitations,data.muscle_weakness,data.sweating,
	data.flushing,data.headache,data.chest_pain,data.back_pain,data.bruising,data.fatigue,
	data.panic,data.sadness,data.body_hair_growth];
	var aName = 'Patient data';
	var value = [{
		name: aName,
		data: dataArray
	}];
	renderBarChart(categoriesArray,value,title,ytitle);
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

var renderBarChart = function (categoriesArray,value,title,ytitle){
	$('#container').highcharts({
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