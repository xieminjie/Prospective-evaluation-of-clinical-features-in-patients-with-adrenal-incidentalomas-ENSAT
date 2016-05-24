$(document).ready(function(){
	getData();
});
var getData = function(){
	$.ajax({
    	type:'GET',
    	url:'/getAllData',
    	contentType:'application/json',
    	data:{
        },
    	success:function(result){
            var count = result.number;
            var minData = result.minData;
            var averageData = result.averageData;
            var maxData = result.maxData;
            updateData(count);
            processData(averageData,minData,maxData);
    	},
    	error:function(result){
    		console.log("error");
    	}
    });
}
var updateData= function(count){
    var countText = $('.number-overal');
    countText.text(count);
}
var processData= function(averageData,minData,maxData){
    var title = 'history data'
    var ytitle = 'point';
    var categoriesArray = ['weight_gain','palpitations','muscle_weakness',
        'sweating','flushing','headache','chest_pain','back_pain','bruising',
        'fatigue','panic','sadness'];
    var averageData =  [averageData.weight_gain,averageData.palpitations,averageData.muscle_weakness,averageData.sweating,
    averageData.flushing,averageData.headache,averageData.chest_pain,averageData.back_pain,averageData.bruising,averageData.fatigue,
    averageData.panic,averageData.sadness];
    var minData =  [minData.weight_gain,minData.palpitations,minData.muscle_weakness,minData.sweating,
    minData.flushing,minData.headache,minData.chest_pain,minData.back_pain,minData.bruising,minData.fatigue,
    minData.panic,minData.sadness];
    var maxData =  [maxData.weight_gain,maxData.palpitations,maxData.muscle_weakness,maxData.sweating,
    maxData.flushing,maxData.headache,maxData.chest_pain,maxData.back_pain,maxData.bruising,maxData.fatigue,
    maxData.panic,maxData.sadness];
    var value = [{
        name: 'minimum value',
        data: minData
    },{
    	name:'average value',
    	data: averageData
    },{
    	name:'maximum value',
    	data:maxData
    }];
    renderBarChart(categoriesArray,value,title,ytitle);
}

var renderBarChart = function (categoriesArray,value,title,ytitle){
    $('#chart').highcharts({
        chart: {
            type: 'bar',
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