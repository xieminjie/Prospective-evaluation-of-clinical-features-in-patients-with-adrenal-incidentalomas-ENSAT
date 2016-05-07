
$(document).ready(function(){
    var socket = io();
    renderBarChart();
    sentCodeRequest(socket);
    receiveData(socket);
    var request = $('#requestVal').val();
    socket.emit('doc search',request);
    receiveCode(socket);
});
var sentCodeRequest = function(socket){
    var requestBtn = $('#sendRequest');
    requestBtn.click(function(){
        socket.emit('request code');
    });
}
var receiveCode = function(socket){
    socket.on('receive code',function(msg){
        $('#requestVal').val(msg);
    });
}
var receiveData = function(socket){
    socket.on('receive overall search',function(msg){
        var title = 'patientData';
        var ytitle = 'point';
        var categoriesArray = ['weight_gain','palpitations','muscle_weakness',
        'sweating','flushing','headache','chest_pain','back_pain','bruising',
        'fatigue','panic','sadness','body_hair_growth'];
        var data = JSON.parse(msg);
        console.log(data);
        var dataArray =  [data.weight_gain,data.palpitations,data.muscle_weakness,data.sweating,
        data.flushing,data.headache,data.chest_pain,data.back_pain,data.bruising,data.fatigue,
        data.panic,data.sadness,data.body_hair_growth];
        var aName = 'Patient data';
        var value = [{
            name: aName,
            data: dataArray
        }];
        renderBarChart(categoriesArray,value,title,ytitle);
    });
}
function renderBarChart(categoriesArray,value,title,ytitle){
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