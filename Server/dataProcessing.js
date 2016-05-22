var exports = module.exports = {

	chartGraphdataProcessing:function(result){
		var count = result.length;
  		var weightgainOveral = 0;
        var palpitationsOveral = 0;
        var highBloodOveral= 0;
        var muscleweaknessOveral = 0;
        var sweatingOveral = 0;
        var flushingOveral = 0;
        var headacheOveral = 0;
        var chestPainOveral = 0;
        var backPainOveral = 0;
        var bruisingOveral = 0;
        var fatigueOveral = 0;
        var panicOveral = 0;
        var sadnessOveral = 0;
        var bodyHairGrowthOveal = 0; 
        var palpitationsAverage = 0;
        var weightgainAverage = 0;
        var highBloodAverage  = 0;
        var muscleweaknessAverage = 0;
        var sweatingAverage = 0;
        var flushingAverage = 0;
        var headacheAverage = 0;
        var chestPainAverage = 0;
        var backPainAverage = 0;
        var fatigueAverage = 0;
        var panicAverage = 0;
        var sadnessAverage = 0;
        var bodyHairGrowthAverage = 0;
        var bruisingAverage = 0;

        var msg;
        var dataObject = new Object();
  			for(var i in result){
    		    weightgainOveral+= result[i].weight_gain;
    		    palpitationsOveral += result[i].palpitations;
            highBloodOveral += result[i].high_blood_pressure;
            muscleweaknessOveral +=result[i].muscle_weakness;
            sweatingOveral += result[i].sweating;
            flushingOveral += result[i].flushing;
            headacheOveral += result[i].headache;
            chestPainOveral += result[i].chest_pain;
            backPainOveral += result[i].back_pain;
            bruisingOveral += result[i].bruising;
            fatigueOveral += result[i].fatigue;
            panicOveral += result[i].panic;
            sadnessOveral+= result[i].sadness;
            bodyHairGrowthOveal+= result[i].body_hair_growth;
    	    }
  			weightgainAverage = Math.floor(weightgainOveral/count);
  			palpitationsAverage = Math.floor(palpitationsOveral/count);
        highBloodAverage = Math.floor(highBloodOveral/count);
        muscleweaknessAverage = Math.floor(muscleweaknessOveral/count);
        sweatingAverage = Math.floor(sweatingOveral/count);
        flushingAverage = Math.floor(flushingOveral/count);
        headacheAverage = Math.floor(headacheOveral/count);
        chestPainAverage  = Math.floor(chestPainOveral/count);
        backPainAverage = Math.floor(backPainOveral/count);
        bruisingAverage = Math.floor(bruisingOveral/count);
        fatigueAverage = Math.floor(fatigueOveral/count);
        panicAverage = Math.floor(panicOveral/count);
        sadnessAverage = Math.floor(sadnessOveral/count);
        bodyHairGrowthAverage = Math.floor(bodyHairGrowthOveal/count);

        dataObject.weight_gain = weightgainAverage;
        dataObject.palpitations = palpitationsAverage;
        dataObject.high_blood_pressure = highBloodAverage;
        dataObject.muscle_weakness = muscleweaknessAverage;
        dataObject.sweating = sweatingAverage;
        dataObject.flushing = flushingAverage;
        dataObject.headache = headacheAverage;
        dataObject.chest_pain = chestPainAverage;
        dataObject.back_pain = backPainAverage;
        dataObject.bruising = bruisingAverage;
        dataObject.fatigue = fatigueAverage;
        dataObject.panic = palpitationsAverage;
        dataObject.sadness = sadnessAverage;
        dataObject.body_hair_growth = bodyHairGrowthAverage;
        msg = JSON.stringify(dataObject);
  		return msg;
	}
};
