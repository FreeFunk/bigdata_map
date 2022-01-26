package com.edgedo.drawing.queryvo;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.drawing.entity.BigdataDriverCarPartitionCountDay;

import java.math.BigDecimal;
import java.util.Date;

public class BigdataDriverCarPartitionCountDayView extends BigdataDriverCarPartitionCountDay {


    /**
     * @Author WangZhen
     * @Description 初始化一个时段的信息 对于单独一天的情况
     * @Date 2020/2/3 20:07
     **/
    public void initByCarInfoAndDriverCardInfoOnlyOne(
            CarInfo carInfo, Date startTime, int yearInt, int monthInt, int dayInt,
            BigdataDriverCardInfo driverCardInfo,int count) {

        this.setTeamId(carInfo.getOwnerTeamId());
        this.setTeamName(carInfo.getOwnerTeamName());
        this.setCarFrameNum(carInfo.getCarFrameNum());
        this.setCarPlateNum(carInfo.getCarPlateNum());
        this.setCarPlateColor(carInfo.getCarPlateColour());
        this.setCarPlateColorText(carInfo.getCarPlateColorText());
        this.setCarType(carInfo.getCarType());

        BigDecimal zero = new BigDecimal(0);
        this.setHighestSpeed(zero);
        this.setNightRunAverageSpeed(zero);
        this.setNightRunMileage(zero);
        this.setHighestSpeed(zero);
        this.setDayRunAverageSpeed(zero);
        this.setDayRunTimeLength(zero);
        this.setDayRunMileage(zero);
        this.setAverageSpeed(zero);
        this.setSumMileage(zero);
        this.setSumRunTimeLength(zero);
        this.setDangerRunTimeLength(zero);
        this.setDangerRunMileage(zero);
        this.setDangerRunAverageSpeed(zero);
        this.setHighSpeedMileage(zero);
        this.setOtherRoadMileage(zero);
        this.setNationalRoadMileage(zero);
       /* this.setOverspeedNum(0);
        this.setSeriousOverspeedNum(0);
        this.setTiredNum(0);
        this.setSeriousTiredNum(0);
        this.setSafetyWarningNum(0);
        this.setSafetrainNum(0);
        this.setWarningRate(new BigDecimal(0));*/

        this.setProvinceId(carInfo.getProvinceId());
        this.setProvinceName(carInfo.getProvinceName());
        this.setCityId(carInfo.getCityId());
        this.setCityName(carInfo.getCityName());
        this.setXianquId(carInfo.getXianquId());
        this.setXianquName(carInfo.getXianquName());
        this.setCompId(carInfo.getComId());
        this.setCompName(carInfo.getComName());
        //一天的起点
        this.setStartTime(startTime);
        //加上23小时59分
        this.setEndTime(new Date(startTime.getTime()+86340000L));
        this.setCreateTime(new Date());
        this.setCountState(0);
        this.setCountDate(dayInt);
        this.setCountMonth(monthInt);
        this.setYearNum(yearInt);
        if(driverCardInfo!=null){
            this.setId(driverCardInfo.getId()+"-" + carInfo.getId() + "-" + dayInt + "-" + count);
            this.setDriverId(driverCardInfo.getId());
            this.setDriverName(driverCardInfo.getDriverName());
            this.setDriverCode(driverCardInfo.getDriverCode());
            this.setDriverPhone(driverCardInfo.getDriverPhone());
        }else{
            this.setId(carInfo.getEmpId()+"-" + carInfo.getId() + "-" + dayInt + "-" + count );
            this.setDriverId(carInfo.getEmpId());
            this.setDriverName(carInfo.getEmpName());
            this.setDriverCode(carInfo.getEmpCode());
            this.setDriverPhone(carInfo.getEmpPhone());
        }

    }

}
