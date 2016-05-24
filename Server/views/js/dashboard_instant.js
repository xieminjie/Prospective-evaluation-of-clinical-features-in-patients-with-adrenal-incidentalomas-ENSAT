$(document).ready(function(){
	getDataData();
});
var getDataData = function(){
    $.ajax({
    	type:'GET',
    	url:'/getInstantOveralData',
    	contentType:'application/json',
    	data:{
        },
    	success:function(result){
            var count = result.number;
            var data = result.data;
            
            processData(data);
    	},
    	error:function(result){
    		console.log("error");
    	}
    });
}
Date.prototype.yyyymmdd = function() {
   var yyyy = this.getFullYear().toString();
   var mm = (this.getMonth()+1).toString(); // getMonth() is zero-based
   var dd  = this.getDate().toString();
   return yyyy + " "+(mm[1]?mm:"0"+mm[0]) +" "+(dd[1]?dd:"0"+dd[0]); // padding
};
var processData= function(msg){
    var  date =new Date();
    var time = date.yyyymmdd();
    var title = 'Instant Data ' + time;
    var ytitle = 'point';
    var categoriesArray = ['weight_gain','palpitations','muscle_weakness',
        'sweating','flushing','headache','chest_pain','back_pain','bruising',
        'fatigue','panic','sadness'];
    var data = msg;
    var dataArray =  [data.weight_gain,data.palpitations,data.muscle_weakness,data.sweating,
    data.flushing,data.headache,data.chest_pain,data.back_pain,data.bruising,data.fatigue,
    data.panic,data.sadness];
    var aName = 'Patient data';
    var value = [{
        name: aName,
        data: dataArray,
        color:'#E91E63'
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