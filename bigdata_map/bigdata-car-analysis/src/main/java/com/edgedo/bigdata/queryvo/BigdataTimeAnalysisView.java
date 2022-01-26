package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.BigdataTimeAnalysis;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigdataTimeAnalysisView extends BigdataTimeAnalysis {

    public BigdataTimeAnalysisView() {
    }

    public BigdataTimeAnalysisView(String carType,int dateInt) {
        this.setId(carType + "-" + dateInt);
        this.setCountDate(dateInt);
        this.setCountMonth(dateInt/100);
        if(this.getDuskMileage()==null) {
            this.setDuskMileage(new BigDecimal(0));
        }
        if(this.getDuskTime()==null){
            this.setDuskTime(new BigDecimal(0));
        }
        if(this.getEarlyMorningMileage()==null){
            this.setEarlyMorningMileage(new BigDecimal(0));
        }
        if(this.getEarlyMorningTime()==null){
            this.setEarlyMorningTime(new BigDecimal(0));
        }
        if(this.getNightMileage()==null){
            this.setNightMileage(new BigDecimal(0));
        }
        if(this.getNightTime()==null){
            this.setNightTime(new BigDecimal(0));
        }
        if(this.getLingchenMileage()==null){
            this.setLingchenMileage(new BigDecimal(0));
        }
        if(this.getLingchenTime()==null){
            this.setLingchenTime(new BigDecimal(0));
        }
        if(this.getNoonMileage()==null){
            this.setNoonMileage(new BigDecimal(0));
        }
        if(this.getNoonTime()==null){
            this.setNoonTime(new BigDecimal(0));
        }
        if(this.getSumDuration()==null){
            this.setSumDuration(new BigDecimal(0));
        }
        if(this.getSumMileage()==null){
            this.setSumMileage(new BigDecimal(0));
        }
        if(this.getFirstDangerMileage()==null){
            this.setFirstDangerMileage(new BigDecimal(0));
        }
        if(this.getSecondDangerMileage()==null){
            this.setSecondDangerMileage(new BigDecimal(0));
        }
        if(this.getThirdDangerMileage()==null){
            this.setThirdDangerMileage(new BigDecimal(0));
        }
        if(this.getFirstDangerTimeNum()==null){
            this.setFirstDangerTimeNum(0);
        }
        if(this.getSecondDangerTimeNum()==null){
            this.setSecondDangerTimeNum(0);
        }
        if(this.getThirdDangerTimeNum()==null){
            this.setThirdDangerTimeNum(0);
        }
    }

    public void initData(){
        if(this.getDuskMileage()==null) {
            this.setDuskMileage(new BigDecimal(0));
        }
        if(this.getDuskTime()==null){
            this.setDuskTime(new BigDecimal(0));
        }
        if(this.getEarlyMorningMileage()==null){
            this.setEarlyMorningMileage(new BigDecimal(0));
        }
        if(this.getEarlyMorningTime()==null){
            this.setEarlyMorningTime(new BigDecimal(0));
        }
        if(this.getNightMileage()==null){
            this.setNightMileage(new BigDecimal(0));
        }
        if(this.getNightTime()==null){
            this.setNightTime(new BigDecimal(0));
        }
        if(this.getLingchenMileage()==null){
            this.setLingchenMileage(new BigDecimal(0));
        }
        if(this.getLingchenTime()==null){
            this.setLingchenTime(new BigDecimal(0));
        }
        if(this.getNoonMileage()==null){
            this.setNoonMileage(new BigDecimal(0));
        }
        if(this.getNoonTime()==null){
            this.setNoonTime(new BigDecimal(0));
        }
        if(this.getSumDuration()==null){
            this.setSumDuration(new BigDecimal(0));
        }
        if(this.getSumMileage()==null){
            this.setSumMileage(new BigDecimal(0));
        }
        if(this.getFirstDangerMileage()==null){
            this.setFirstDangerMileage(new BigDecimal(0));
        }
        if(this.getSecondDangerMileage()==null){
            this.setSecondDangerMileage(new BigDecimal(0));
        }
        if(this.getThirdDangerMileage()==null){
            this.setThirdDangerMileage(new BigDecimal(0));
        }
        if(this.getFirstDangerTimeNum()==null){
            this.setFirstDangerTimeNum(0);
        }
        if(this.getSecondDangerTimeNum()==null){
            this.setSecondDangerTimeNum(0);
        }
        if(this.getThirdDangerTimeNum()==null){
            this.setThirdDangerTimeNum(0);
        }
    }
    //分析各种比率
    public void fenxiRate() {
        //凌晨，清晨，中午，黄昏，午夜
        BigDecimal duskMileage = this.getDuskMileage();
        BigDecimal duskTime = this.getDuskTime();
        BigDecimal earlyMorningMileage = this.getEarlyMorningMileage();
        BigDecimal earlyMorningTime = this.getEarlyMorningTime();
        BigDecimal lingchenMileage = this.getLingchenMileage();
        BigDecimal lingchenTime = this.getLingchenTime();
        BigDecimal nightMileage = this.getNightMileage();
        BigDecimal nightTime = this.getNightTime();
        BigDecimal noonMileage = this.getNoonMileage();
        BigDecimal noonTime = this.getNoonTime();
        BigDecimal mileTotal = new BigDecimal(0);
        mileTotal = mileTotal.add(duskMileage).add(earlyMorningMileage)
        .add(lingchenMileage).add(nightMileage).add(noonMileage);

        BigDecimal timeTotal = new BigDecimal(0);
        timeTotal = timeTotal.add(duskTime).add(earlyMorningTime).add(lingchenTime)
                .add(nightTime).add(noonTime);
        BigDecimal duskMileageRate = new BigDecimal(0);
        BigDecimal earlyMorningMileageRate = new BigDecimal(0);
        BigDecimal lingchenMileageRate = new BigDecimal(0);
        BigDecimal nightMileageRate = new BigDecimal(0);
        BigDecimal noonMileageRate =  new BigDecimal(0);
        if(mileTotal.doubleValue()!=0){
            duskMileageRate = duskMileage.divide(mileTotal,2, RoundingMode.HALF_UP);
            earlyMorningMileageRate = earlyMorningMileage.divide(mileTotal,2, RoundingMode.HALF_UP);
            lingchenMileageRate = lingchenMileage.divide(mileTotal,2, RoundingMode.HALF_UP);
            nightMileageRate = nightMileage.divide(mileTotal,2, RoundingMode.HALF_UP);
            noonMileageRate = noonMileage.divide(mileTotal,2, RoundingMode.HALF_UP);
        }

        this.setDuskMileageRete(duskMileageRate);
        this.setEarlyMorningMileageRate(earlyMorningMileageRate);
        this.setLingchenMileageRate(lingchenMileageRate);
        this.setNightMileageRate(nightMileageRate);
        this.setNoonMileageRate(noonMileageRate);

        BigDecimal duskTimeRate = new BigDecimal(0);
        BigDecimal earlyTimeRate = new BigDecimal(0);
        BigDecimal lingchenTimeRate = new BigDecimal(0);
        BigDecimal nightTimeRate = new BigDecimal(0);
        BigDecimal noonTimeRate =  new BigDecimal(0);
        if(timeTotal.doubleValue()!=0){
            duskTimeRate = duskTime.divide(timeTotal,2, RoundingMode.HALF_UP);
            earlyTimeRate = earlyMorningTime.divide(timeTotal,2, RoundingMode.HALF_UP);
            lingchenTimeRate = lingchenTime.divide(timeTotal,2, RoundingMode.HALF_UP);
            nightTimeRate = nightTime.divide(timeTotal,2, RoundingMode.HALF_UP);
            noonTimeRate =  noonTime.divide(timeTotal,2, RoundingMode.HALF_UP);
        }
        this.setDuskTimeRate(duskTimeRate);
        this.setEarlyMorningTimeRate(earlyTimeRate);
        this.setLingchenTimeRate(lingchenTimeRate);
        this.setNightTimeRate(nightTimeRate);
        this.setNoonTimeRate(noonTimeRate);

        //设置一类 二类危险时段的里程
        this.setFirstDangerMileage(this.getLingchenMileage() );
        this.setSecondDangerMileage(this.getEarlyMorningMileage().add(this.getDuskMileage()) );
        this.setThirdDangerMileage(this.getNoonMileage());


    }
}
