$(document).ready(function(){
	downloadGenderData();
	downloadAgeData(0,30,3);
	downloadAgeData(30,50,3);
	downloadAgeData(50,100,3);

});
var maleNum = null;
var femaleNum = null;
var ageCountArray = [];

var downloadGenderData = function(){
	console.log("loadData");
	$.ajax({
            type: "GET",
            url: '/genderStastic',
            contentType: 'application/json',
            data:{
            },
            success: function(r) {
            	console.log(r);
            	var msg = JSON.parse(r);
            	var maleNum = msg.male;
            	var femaleNum = msg.female;
            	var overallNum = maleNum+femaleNum;
            	loadGenderPieChart(maleNum,femaleNum);
            	loadOveralData(overallNum,maleNum,femaleNum);
            },
            error: function(r){
                console.log("error");
            }
    });
}
var downloadAgeData = function(minAge,maxAge,intervalNum){
	   $.ajax({
            type: "GET",
            url: '/ageStastic',
            contentType: 'application/json',
            data:{
            	minAge:minAge,
            	maxAge:maxAge
            },
            success: function(r) {
            	var msg = JSON.parse(r);
            	console.log(msg);
            	var ageOne = msg.ageCount[0].count;
            	var minAge = msg.minAge;
            	ageCountArray.push(ageOne);
            	if(ageCountArray.length==intervalNum){
            		loadAgeChart(ageCountArray);
            	}
            },
            error: function(r){
                console.log("error");
            }
   		 });
}
var loadAgeChart = function(ageCountArray){
	loadAgePieChart(ageCountArray);
}
var loadOveralData = function (overalNum,maleNum,femaleNum){
	console.log(overalNum);
	var overalText = $('.number-overal');
	var maleText = $('.number-male');
	var femaleText = $('.number-female');
	overalText.text(overalNum);
	maleText.text(maleNum);
	femaleText.text(femaleNum);

}
var loadAgePieChart = function(loadAgeChart){
	$('#ageChart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Age Proportion'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
                name: '0-30',
                y: loadAgeChart[0]
            }, {
                name: '30-50',
                y: loadAgeChart[1]
            }, {
                name: '>50',
                y: loadAgeChart[2]
            }]
        }]
    });
}
var loadGenderPieChart = function(maleNum,feMaleNum){
	$('#genderChart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Gender Proportion'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
                name: 'Male',
                y: maleNum
            }, {
                name: 'Female',
                y: feMaleNum,
            }]
        }]
    });
}