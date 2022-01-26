package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.BigdataOverspeedAnalysisSumCount;

import java.math.BigDecimal;
import java.util.Date;

public class BigdataOverspeedAnalysisSumCountView extends BigdataOverspeedAnalysisSumCount {

    public void initData(String countType , String carType,int month,Date countTime){
        this.setCarType(carType);


        this.setCountMonth(month);
        this.setCountYear(month/100);
        this.setCountTime(countTime);
        this.setCreateTime(new Date());
        this.setCountType(countType);
        if(countType.equals("month")){
            this.setId(carType+"-" + month);
        }else if(countType.equals("year")){
            this.setId(carType + "-" + this.getCountYear());
        }
        this.setSumNightOverspeedMileage(new BigDecimal(0));
        this.setSumNightOverspeedNum(0);
        this.setSumNightOverspeedTime(new BigDecimal(0));
        this.setSumOverspeedMileage(new BigDecimal(0));
        this.setSumOverspeedNum(0);
        this.setSumOverspeedTime(new BigDecimal(0));
        this.setSumSeriousOverspeedMileage(new BigDecimal(0));
        this.setSumSeriousOverspeedNum(0);
        this.setSumSeriousOverspeedTime(new BigDecimal(0));
    }

}
