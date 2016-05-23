$(document).ready(function(){
	loadData('male');
});
var maleNum = null;
var femaleNum = null;
var loadData = function(gender){
	console.log("loadData");
	$.ajax({
            type: "GET",
            url: '/genderStastic',
            contentType: 'application/json',
            data:{
            	gender:gender
            },
            success: function(r) {
            	console.log(r);
            	var msg = JSON.parse(r);
            	console.log(msg.male);
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
var loadOveralData = function (overalNum,maleNum,femaleNum){
	console.log(overalNum);
	var overalText = $('.number-overal');
	var maleText = $('.number-male');
	var femaleText = $('.number-female');
	overalText.text(overalNum);
	maleText.text(maleNum);
	femaleText.text(feMaleNum);

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