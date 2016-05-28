
$(document).ready(function(){
	loadData();
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
var processData= function(msg){
	var title = 'Overal Data Chart';
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
		data: dataArray,
		color:'#009688'
	}];
	renderBarChart(categoriesArray,value,title,ytitle);
}

var renderBarChart = function (categoriesArray,value,title,ytitle){
	$('#chart').highcharts({
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