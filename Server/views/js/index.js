
$(document).ready(function(){
	var socket = io();
	//renderBarChart();
	sentDataRequest(socket);
	receiveData(socket);
});
var sentDataRequest = function(socket){
	var requestBtn = $('#sendRequest');
	requestBtn.click(function(){
		var request = $('#requestVal').val();
		socket.emit('doc search',request);
	});
}
var receiveData = function(socket){
	socket.on('receive doc search',function(msg){
		$('#msg').text(msg);
	});
}
var categoriesArray =  ['Apples', 'Bananas', 'Oranges'];
function renderBarChart(categoriesArray){
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