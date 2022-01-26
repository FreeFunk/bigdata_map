package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.BigdataFatigueAnalysisSumCount;

import java.math.BigDecimal;
import java.util.Date;

public class BigdataFatigueAnalysisSumCountView extends BigdataFatigueAnalysisSumCount {

    public BigdataFatigueAnalysisSumCountView() {

    }

    public BigdataFatigueAnalysisSumCountView(
            int monthInt,String countType,String carType,Date countTime) {

        this.setCountType(countType);
        this.setCarType(carType);
        this.setCountMonth(monthInt);
        this.setCountYear(monthInt/100);
        if(countType.equals("month")){
            this.setId(carType + "-" + monthInt);
        }else if(countType.equals("year")){
            this.setId(carType + "-" + this.getCountYear());
        }

        this.setCountTime(countTime);
        this.setCreateTime(new Date());
        this.setSumFatigueMileage(new BigDecimal(0));
        this.setSumFatigueNum(0);
        this.setSumFatigueTime(new BigDecimal(0));
        this.setSumNightFatigueMileage(new BigDecimal(0));
        this.setSumNightFatigueNum(0);
        this.setSumNightFatigueTime(new BigDecimal(0));
        this.setSumSeriousFatigueMileage(new BigDecimal(0));
        this.setSumSeriousFatigueNum(0);
        this.setSumSeriousFatigueTime(new BigDecimal(0));

    }


}
