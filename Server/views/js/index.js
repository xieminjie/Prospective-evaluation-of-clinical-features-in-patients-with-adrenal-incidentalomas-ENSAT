
$(document).ready(function(){
	var socket = io();
	renderChart();
});
var categoriesArray =  ['Apples', 'Bananas', 'Oranges'];
function renderChart(categoriesArray){
	$('#container').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Fruit Consumption'
        },
        xAxis: {
            categories: categoriesArray
        },
        yAxis: {
            title: {
                text: 'Fruit eaten'
            }
        },
        series: [{
            name: 'Jane',
            data: [1, 0, 4]
        }, {
            name: 'John',
            data: [5, 7, 3]
        }]
    });
}