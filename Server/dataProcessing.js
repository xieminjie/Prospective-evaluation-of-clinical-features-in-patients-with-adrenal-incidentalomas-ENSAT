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
	},
    historyDataHander:function(result){
        var number = result.length;
        var averageData = JSON.parse(module.exports.chartGraphdataProcessing(result));
        var minData = JSON.parse(module.exports.getMinDataHandler(result));
        var maxData = JSON.parse(module.exports.getMaxDataHandler(result));
        var msg = {
            number:number,
            averageData:averageData,
            minData:minData,
            maxData:maxData
        }
        return msg;
    },

    instantDataHandler:function(result){
        var number = result.length;
        var data = JSON.parse(module.exports.chartGraphdataProcessing(result));
        console.log(data);
        var msg = {
            number:number,
            data:data
        }
        return msg;
    },

    getMinDataHandler:function(result){
        var weightgainMin= 100;
        var palpitationsMin = 100;
        var highBloodMin= 100;
        var muscleweaknessMin = 100;
        var sweatingMin = 100;
        var flushingMin = 100;
        var headacheMin = 100;
        var chestPainMin = 100;
        var backPainMin =100;
        var bruisingMin = 100;
        var fatigueMin = 100;
        var panicMin = 100;
        var sadnessMin = 100;
        var dataObject = new Object();
        var msg;
        for(var i in result){
            var weightgain = result[i].weight_gain;
            if(weightgain<weightgainMin){
                weightgainMin = weightgain
            }
            var palpitations= result[i].palpitations;
            if(palpitations<palpitationsMin){
                palpitationsMin = palpitations;
            }
            var highBlood = result[i].high_blood_pressure;
            if(highBlood<highBloodMin){
                highBloodMin = highBlood;
            }
            var muscleweakness=result[i].muscle_weakness;
            if(muscleweakness<muscleweaknessMin){
                muscleweaknessMin = muscleweakness;
            }
            var sweating= result[i].sweating;
            if(sweating<sweatingMin){
                sweatingMin = sweating;
            }
            var flushing= result[i].flushing;
            if(flushing<flushingMin){
                flushingMin = flushing;
            }
            var headache= result[i].headache;
            if(headache<headacheMin){
                headacheMin = headache;
            }
            var chestPain= result[i].chest_pain;
            if(chestPain<chestPainMin){
                chestPainMin = chestPain;
            }
            var backPain= result[i].back_pain;
            if(backPain<backPainMin){
                backPainMin = backPain;
            }
            var bruising= result[i].bruising;
            if(backPain<backPainMin){
                backPainMin = backPain;
            }
            var fatigue= result[i].fatigue;
            if(fatigue<fatigueMin){
                fatigueMin = fatigue;
            }
            var panic= result[i].panic;
            if(panic<panicMin){
                panicMin = panic;
            }
            var sadness= result[i].sadness;
            if(sadness<sadnessMin){
                sadnessMin = sadness;
            }
        }
        dataObject.weight_gain = weightgainMin;
        dataObject.palpitations = palpitationsMin;
        dataObject.high_blood_pressure = highBloodMin;
        dataObject.muscle_weakness = muscleweaknessMin;
        dataObject.sweating = sweatingMin;
        dataObject.flushing = flushingMin;
        dataObject.headache = headacheMin;
        dataObject.chest_pain = chestPainMin;
        dataObject.back_pain = backPainMin;
        dataObject.bruising = bruisingMin;
        dataObject.fatigue = fatigueMin;
        dataObject.panic = palpitationsMin;
        dataObject.sadness = sadnessMin;
        msg = JSON.stringify(dataObject);
        return msg;
    },
    getMaxDataHandler:function(result){
        var weightgainMax= 0;
        var palpitationsMax = 0;
        var highBloodMax= 0;
        var muscleweaknessMax = 0;
        var sweatingMax = 0;
        var flushingMax = 0;
        var headacheMax = 0;
        var chestPainMax = 0;
        var backPainMax =0;
        var bruisingMax = 0;
        var fatigueMax = 0;
        var panicMax = 0;
        var sadnessMax = 0;
        var dataObject = new Object();
        var msg;
        for(var i in result){
            var weightgain = result[i].weight_gain;
            if(weightgain>weightgainMax){
                weightgainMax = weightgain
            }
            var palpitations= result[i].palpitations;
            if(palpitations>palpitationsMax){
                palpitationsMax = palpitations;
            }
            var highBlood = result[i].high_blood_pressure;
            if(highBlood>highBloodMax){
                highBloodMax = highBlood;
            }
            var muscleweakness=result[i].muscle_weakness;
            if(muscleweakness>muscleweaknessMax){
                muscleweaknessMax = muscleweakness;
            }
            var sweating= result[i].sweating;
            if(sweating>sweatingMax){
                sweatingMax = sweating;
            }
            var flushing= result[i].flushing;
            if(flushing>flushingMax){
                flushingMax = flushing;
            }
            var headache= result[i].headache;
            if(headache>headacheMax){
                headacheMax = headache;
            }
            var chestPain= result[i].chest_pain;
            if(chestPain>chestPainMax){
                chestPainMax = chestPain;
            }
            var backPain= result[i].back_pain;
            if(backPain>backPainMax){
                backPainMax = backPain;
            }
            var bruising= result[i].bruising;
            if(backPain>backPainMax){
                backPainMax = backPain;
            }
            var fatigue= result[i].fatigue;
            if(fatigue>fatigueMax){
                fatigueMax = fatigue;
            }
            var panic= result[i].panic;
            if(panic>panicMax){
                panicMax = panic;
            }
            var sadness= result[i].sadness;
            if(sadness>sadnessMax){
                sadnessMax = sadness;
            }
        }
        dataObject.weight_gain = weightgainMax;
        dataObject.palpitations = palpitationsMax;
        dataObject.high_blood_pressure = highBloodMax;
        dataObject.muscle_weakness = muscleweaknessMax;
        dataObject.sweating = sweatingMax;
        dataObject.flushing = flushingMax;
        dataObject.headache = headacheMax;
        dataObject.chest_pain = chestPainMax;
        dataObject.back_pain = backPainMax;
        dataObject.bruising = bruisingMax;
        dataObject.fatigue = fatigueMax;
        dataObject.panic = palpitationsMax;
        dataObject.sadness = sadnessMax;
        msg = JSON.stringify(dataObject);
        return msg;
    }
};
