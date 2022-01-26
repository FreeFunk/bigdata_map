package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.CityTransportCapacityAnalysis;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CityTransportCapacityAnalysisView extends CityTransportCapacityAnalysis {

    public void fenxiData(){
        DecimalFormat df = new DecimalFormat("0.0000");
        int all = this.getCarTotalNum();
        int onlineNum =  this.getOnlineNum();
        int operat = this.getOperationNum();
        double onlienRate = onlineNum*1.0/all;
        double operatRate = 0;
        if(onlineNum>0){
            operatRate = operat*1.0/onlineNum;
        }
        String onlienRateStr = df.format(onlienRate);
        String operatRateStr = df.format(operatRate);
        this.setOnlineRate(new BigDecimal(onlienRateStr));
        this.setOperationRate(new BigDecimal(operatRateStr));

    }

}
