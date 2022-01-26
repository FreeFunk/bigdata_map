package com.edgedo.drawing.queryvo;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigdataDriverCountMonthAndYearView extends BigdataDriverCountMonthAndYear {
    /**
     * @Author WangZhen
     * @Description 无数据的使用此方法进行各个数据的初始化
     * @Date 2020/2/6 16:36
     **/
    public void initNullData(){

        this.setSumMileage(new BigDecimal(0));
        this.setSumRunTimeLength(new BigDecimal(0));
        this.setAverageSpeed(new BigDecimal(0));
        this.setDayRunMileage(new BigDecimal(0));
        this.setDayRunTimeLength(new BigDecimal(0));
        this.setDayRunAverageSpeed(new BigDecimal(0));
        this.setNightRunMileage(new BigDecimal(0));
        this.setNightRunTimeLength(new BigDecimal(0));
        this.setNightRunAverageSpeed(new BigDecimal(0));
        this.setDangerRunMileage(new BigDecimal(0));
        this.setDangerRunTimeLength(new BigDecimal(0));
        this.setDangerRunAverageSpeed(new BigDecimal(0));
        this.setHighestSpeed(new BigDecimal(0));
        this.setHighSpeedMileage(new BigDecimal(0));
        this.setNationalRoadMileage(new BigDecimal(0));
        this.setOtherRoadMileage(new BigDecimal(0));

        this.setSafetrainNum(0);
        this.setSafetyWarningNum(0);
        this.setSeriousOverspeedNum(0);
        this.setSeriousTiredNum(0);
        this.setOverspeedNum(0);
        this.setTiredNum(0);
        this.setWarningRate(new BigDecimal(0));
    }

    /**
     * @Author WangZhen
     * @Description 计算平均速度和报警率
     * @Date 2020/2/6 16:36
     **/
    public void countData(){
        //计算平均速度
        BigDecimal sumMileage = this.getSumMileage();
        if(sumMileage==null)sumMileage=new BigDecimal(0);
        BigDecimal sumRunTimeLength = this.getSumRunTimeLength();
        if(sumRunTimeLength==null)sumRunTimeLength=new BigDecimal(0);
        BigDecimal averageSpeed = null;
        //平均速度
        if(sumRunTimeLength.doubleValue()==0){
            averageSpeed = new BigDecimal(0);
        }else{
            averageSpeed =  sumMileage.multiply(new BigDecimal(60))
                    .divide( sumRunTimeLength,3, BigDecimal.ROUND_FLOOR);
        }
        this.setAverageSpeed(averageSpeed);
        BigDecimal dayMileage = this.getDayRunMileage();
        if(dayMileage==null)dayMileage=new BigDecimal(0);
        BigDecimal dayRunTimeLength = this.getDayRunTimeLength();
        if(dayRunTimeLength==null)dayRunTimeLength=new BigDecimal(0);
        BigDecimal dayAverageSpeed = null;
        //平均速度
        if(dayRunTimeLength.doubleValue()==0){
            dayAverageSpeed = new BigDecimal(0);
        }else{
            dayAverageSpeed =  dayMileage.multiply(new BigDecimal(60))
                    .divide( dayRunTimeLength,3, BigDecimal.ROUND_FLOOR);
        }
        this.setDayRunAverageSpeed(dayAverageSpeed);

        BigDecimal nightMileage = this.getNightRunMileage();
        if(nightMileage==null)nightMileage=new BigDecimal(0);
        BigDecimal nightRunTimeLength = this.getNightRunTimeLength();
        if(nightRunTimeLength==null)nightRunTimeLength=new BigDecimal(0);
        BigDecimal nightAverageSpeed = null;
        //平均速度
        if(nightRunTimeLength.doubleValue()==0){
            nightAverageSpeed = new BigDecimal(0);
        }else{
            nightAverageSpeed =  nightMileage.multiply(new BigDecimal(60))
                    .divide( nightRunTimeLength,3, BigDecimal.ROUND_FLOOR);
        }
        this.setNightRunAverageSpeed(nightAverageSpeed);

        BigDecimal dangerMileage = this.getDangerRunMileage();
        if(dangerMileage==null)dangerMileage=new BigDecimal(0);
        BigDecimal dangerRunTimeLength = this.getDangerRunTimeLength();
        if(dangerRunTimeLength==null)dangerRunTimeLength = new BigDecimal(0);
        BigDecimal dangerAverageSpeed = null;
        //平均速度
        if(dangerRunTimeLength.doubleValue()==0){
            dangerAverageSpeed = new BigDecimal(0);
        }else{
            dangerAverageSpeed =  dangerMileage.multiply(new BigDecimal(60))
                    .divide( dangerRunTimeLength,3, BigDecimal.ROUND_FLOOR);
        }
        this.setDangerRunAverageSpeed(dangerAverageSpeed);

        //计算百公里报警系数=所有报警数量/(公里/100)
        int count = 0;
        Integer overSpeed = this.getOverspeedNum();
        if(overSpeed==null){overSpeed=0;this.setOverspeedNum(overSpeed);}

        Integer safetyWarningNum = this.getSafetyWarningNum();
        if(safetyWarningNum==null){safetyWarningNum=0;this.setSafetyWarningNum(safetyWarningNum);}

        Integer tiredNum = this.getTiredNum();
        if(tiredNum==null){tiredNum=0;this.setTiredNum(tiredNum);}

        Integer seriousOverspeedNum = this.getSeriousOverspeedNum();
        if(seriousOverspeedNum==null){seriousOverspeedNum=0;this.setSeriousOverspeedNum(seriousOverspeedNum);}

        Integer seriousTiredNum = this.getSeriousTiredNum();
        if(seriousTiredNum==null){seriousTiredNum=0;this.setSeriousTiredNum(seriousTiredNum);}

        Integer safetrainNum = this.getSafetrainNum();
        if(safetrainNum==null){safetrainNum=0;this.setSafetrainNum(safetrainNum);}
        count += overSpeed;
        count += safetyWarningNum;
        count += tiredNum;
        if(count>0){
            if(sumMileage.intValue()==0){
                this.setWarningRate(new BigDecimal(0));
            }else{
                BigDecimal warningRate = new BigDecimal(count*100).divide(sumMileage,3, RoundingMode.FLOOR);
                this.setWarningRate(warningRate);
            }

        }else{
            this.setWarningRate(new BigDecimal(0));
        }
    }

    /**
     * @Author WangZhen
     * @Description 设置司机信息
     * @Date 2020/2/6 16:46
     **/
    public void confDriverInfo(BigdataDriverCardInfo driver) {
        this.setDriverId(driver.getId());
        this.setCompId(driver.getCompId());
        this.setCompName(driver.getCompName());
        this.setTeamId(driver.getTeamId());
        this.setTeamName(driver.getTeamName());
        this.setDriverAge(driver.getDriverAge());
        this.setDriverCode(driver.getDriverCode());
        this.setDriverIdCard(driver.getDriverIdCard());
        this.setDriverName(driver.getDriverName());
        this.setDriverPhone(driver.getDriverPhone());
        this.setDriverSex(driver.getDriverSex());
        this.setProvinceId(driver.getProvinceId());
        this.setProvinceName(driver.getProvinceName());
        this.setCityId(driver.getCityId());
        this.setCityName(driver.getCityName());
        this.setXianquId(driver.getXianquId());
        this.setXianquName(driver.getXianquName());
    }

}
