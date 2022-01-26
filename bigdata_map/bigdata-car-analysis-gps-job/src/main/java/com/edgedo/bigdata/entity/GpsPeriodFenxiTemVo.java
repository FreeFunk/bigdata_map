package com.edgedo.bigdata.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WangZhen
 * @description
 * @date 2020/2/5
 */
public class GpsPeriodFenxiTemVo {

    BigdataCarRealtimeGps firstGps = null;
    //总的计算：分段开始有速度的点
    BigdataCarRealtimeGps startSpeedGps = null;
    //结束
    BigdataCarRealtimeGps endSpeedGps = null;
    //开始里程
    BigDecimal beginMileage = null;
    //结束的里程
    BigDecimal latestMileage = null;
    //总里程
    BigDecimal totalMileage = new BigDecimal(0);
    //总的计算：总共行驶时长(秒)
    BigDecimal totalDriveSecond = new BigDecimal(0);
    //总分钟
    BigDecimal totalDriveMin =  new BigDecimal(0);
    //平均速度
    BigDecimal averageSpeed =  new BigDecimal(0);
    //最高速度
    double highSpeed =  0.0;



    public BigDecimal getBeginMileage() {
        return beginMileage;
    }

    public void setBeginMileage(BigDecimal beginMileage) {
        this.beginMileage = beginMileage;
    }

    public BigDecimal getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(BigDecimal totalMileage) {
        this.totalMileage = totalMileage;
    }

    public BigdataCarRealtimeGps getFirstGps() {
        return firstGps;
    }

    public void setFirstGps(BigdataCarRealtimeGps firstGps) {
        this.firstGps = firstGps;
    }



    public BigdataCarRealtimeGps getStartSpeedGps() {
        return startSpeedGps;
    }

    public void setStartSpeedGps(BigdataCarRealtimeGps startSpeedGps) {
        this.startSpeedGps = startSpeedGps;
    }

    public BigdataCarRealtimeGps getEndSpeedGps() {
        return endSpeedGps;
    }

    public void setEndSpeedGps(BigdataCarRealtimeGps endSpeedGps) {
        this.endSpeedGps = endSpeedGps;
    }

    public BigDecimal getLatestMileage() {
        return latestMileage;
    }

    public void setLatestMileage(BigDecimal latestMileage) {
        this.latestMileage = latestMileage;
    }

    public BigDecimal getTotalDriveSecond() {
        return totalDriveSecond;
    }

    public void setTotalDriveSecond(BigDecimal totalDriveSecond) {
        this.totalDriveSecond = totalDriveSecond;
    }

    public BigDecimal getTotalDriveMin() {
        return totalDriveMin;
    }

    public void setTotalDriveMin(BigDecimal totalDriveMin) {
        this.totalDriveMin = totalDriveMin;
    }

    public BigDecimal getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getHighSpeed() {
        return highSpeed;
    }

    public void setHighSpeed(double highSpeed) {
        this.highSpeed = highSpeed;
    }

    /**
     * @Author WangZhen
     * @Description 分析
     * @Date 2020/2/5 20:14
     **/
    public void fenxiFunc(
            BigdataCarRealtimeGps tempGps,
            boolean  jumpTimeFlag,
            double realSpeed,
            BigdataCarRealtimeGps lastGps){

        if(realSpeed>highSpeed){
            highSpeed = realSpeed;
        }
        //1.行驶里程
        if(firstGps==null){
            firstGps = tempGps;
            beginMileage = firstGps.getMileage();
        }
        //2.行驶时长
        if(jumpTimeFlag){
            //速度是0了，那么说明停车了，计算停车开始和行驶的结束
            if(startSpeedGps!=null && lastGps!=null){//如果开始有速度的点 不为空说明是行驶一段时间然后停车了
                //计算本段的行驶时长
                Date stopSpeedTime = lastGps.getLastPositionTime();
                Date startSpeedTime = startSpeedGps.getLastPositionTime();
                long milSec = stopSpeedTime.getTime() - startSpeedTime.getTime();
                long sec = milSec/1000;
                //行驶里程
                BigDecimal stopMileage = lastGps.getMileage();
                BigDecimal startMileage = startSpeedGps.getMileage();
                BigDecimal subMileage = stopMileage.subtract(startMileage);
                //判断里程误报
                if(sec>0){
                    if(subMileage.compareTo(BigDecimal.ZERO)==1 && subMileage.compareTo(new BigDecimal(1500))<0){
                        //分段求平均速度（超过120不记录）
                        BigDecimal averageSpeedNew = subMileage.multiply(new BigDecimal(60*60))
                                .divide( new BigDecimal(sec),3, BigDecimal.ROUND_FLOOR);
                        if(averageSpeedNew.compareTo(new BigDecimal(120))<0){
                            totalMileage = totalMileage.add(subMileage);
                            totalDriveSecond = totalDriveSecond.add(new BigDecimal(sec));
                        }
                    }
                }
            }
            startSpeedGps=null;
        }else{

            if(realSpeed>0){
                //如果分段开始的点为空----说明处在停车状态 并且 如果当前这个点时有速度那么说明从停车开始发动了
                //是行驶状态
                if(startSpeedGps==null){
                    startSpeedGps  = tempGps;
                }
            }else{
                //速度是0了，那么说明停车了，计算停车开始和行驶的结束
                if(startSpeedGps!=null && lastGps!=null){//如果开始有速度的点 不为空说明是行驶一段时间然后停车了
                    //计算本段的行驶时长
                    Date stopSpeedTime = lastGps.getLastPositionTime();
                    Date startSpeedTime = startSpeedGps.getLastPositionTime();
                    long milSec = stopSpeedTime.getTime() - startSpeedTime.getTime();
                    long sec = milSec/1000;
                    //行驶里程
                    BigDecimal stopMileage = lastGps.getMileage();
                    BigDecimal startMileage = startSpeedGps.getMileage();
                    BigDecimal subMileage = stopMileage.subtract(startMileage);
                    //判断里程误报
                    if(sec>0){
                        if(subMileage.compareTo(BigDecimal.ZERO)==1 && subMileage.compareTo(new BigDecimal(1500))<0){
                            //分段求平均速度（超过120不记录）
                            BigDecimal averageSpeedNew = subMileage.multiply(new BigDecimal(60*60))
                                    .divide( new BigDecimal(sec),3, BigDecimal.ROUND_FLOOR);
                            if(averageSpeedNew.compareTo(new BigDecimal(120))<0){
                                totalMileage = totalMileage.add(subMileage);
                                totalDriveSecond = totalDriveSecond.add(new BigDecimal(sec));
                            }
                        }
                    }
                }
                startSpeedGps=null;
            }
        }
        endSpeedGps = tempGps;
    }

    public boolean isDrive() {
        return (latestMileage==null || beginMileage==null);
    }

    //汇总统计
    public void sumData(){
        //看看白天时段的最后一段的时间和里程
        if(endSpeedGps!=null){
            /*BigDecimal baitianCurrentMileDrive = endSpeedGps.getMileage().subtract(
                    beginMileage);
            totalMileage = baitianCurrentMileDrive;*/
            if(startSpeedGps!=null&&endSpeedGps!=null){//开始的不为空说明在时间临界点时也在开车
                Date baitianLastStartTime = startSpeedGps.getLastPositionTime();
                Date baitianLastEndTime = endSpeedGps.getLastPositionTime();
                long milSec = baitianLastEndTime.getTime() - baitianLastStartTime.getTime();
                long sec = milSec/1000;
                BigDecimal stopMileage = endSpeedGps.getMileage();
                BigDecimal startMileage = startSpeedGps.getMileage();
                BigDecimal subMileage = stopMileage.subtract(startMileage);
                //判断里程误报
                if(sec>0){
                    if(subMileage.compareTo(BigDecimal.ZERO)==1 && subMileage.compareTo(new BigDecimal(1500))<0){
                        //分段求平均速度（超过120不记录）
                        BigDecimal averageSpeedNew = subMileage.multiply(new BigDecimal(60*60))
                                .divide( new BigDecimal(sec),3, BigDecimal.ROUND_FLOOR);
                        if(averageSpeedNew.compareTo(new BigDecimal(120))<0){
                            totalMileage = totalMileage.add(subMileage);
                            totalDriveSecond = totalDriveSecond.add(new BigDecimal(sec));
                        }
                    }
                }
            }
        }else{
            totalDriveSecond = new BigDecimal(0);
        }
        //设置凌晨的总时长
        totalDriveMin = totalDriveSecond.divide(new BigDecimal(60),2,BigDecimal.ROUND_CEILING);
        //平均速度
        if(totalDriveMin.doubleValue()==0){
            averageSpeed = new BigDecimal(0);
        }else{
            averageSpeed =  totalMileage.multiply(new BigDecimal(60))
                    .divide( totalDriveMin,3, BigDecimal.ROUND_FLOOR);
        }
    }

    //相加统计
    public void plusSumData(GpsPeriodFenxiTemVo ... targets){

        for(GpsPeriodFenxiTemVo t : targets ){
            double hSpeed = t.getHighSpeed();
            if(hSpeed>highSpeed){
                highSpeed = hSpeed;
            }
            totalMileage = totalMileage.add(t.getTotalMileage());
            totalDriveSecond = totalDriveSecond.add(t.getTotalDriveSecond());
        }
        //设置凌晨的总时长
        totalDriveMin = totalDriveSecond.divide(new BigDecimal(60),2,BigDecimal.ROUND_CEILING);
        //平均速度
        if(totalDriveMin.intValue()==0){
            averageSpeed = new BigDecimal(0);
        }else{
            averageSpeed =  totalMileage.multiply(new BigDecimal(60))
                    .divide( totalDriveMin,3, BigDecimal.ROUND_FLOOR);
        }

    }


    /**
     * @Author WangZhen
     * @Description 两个做减法减出一个新的结果
     * @Date 2020/2/7 11:05
     **/
    public GpsPeriodFenxiTemVo subtract(GpsPeriodFenxiTemVo  ... targets) {
        GpsPeriodFenxiTemVo result = new GpsPeriodFenxiTemVo();
        for(GpsPeriodFenxiTemVo t : targets ){
            double hSpeed = t.getHighSpeed();
            if(hSpeed>highSpeed){
                highSpeed = hSpeed;
            }
            result.setTotalMileage(totalMileage.subtract(t.getTotalMileage()));;
            result.setTotalDriveSecond(totalDriveSecond.subtract(t.getTotalDriveSecond()));;
        }
        //设置凌晨的总时长
        result.setTotalDriveMin(result.getTotalDriveSecond().divide(new BigDecimal(60),2,BigDecimal.ROUND_CEILING));;
        //平均速度
        if(result.getTotalDriveMin().intValue()==0){
            result.setAverageSpeed(new BigDecimal(0));
        }else{

            result.setAverageSpeed(
                    result.getTotalMileage().multiply(new BigDecimal(60))
                    .divide( result.getTotalDriveMin(),3, BigDecimal.ROUND_FLOOR)
            );
        }
        return result;

    }
}
