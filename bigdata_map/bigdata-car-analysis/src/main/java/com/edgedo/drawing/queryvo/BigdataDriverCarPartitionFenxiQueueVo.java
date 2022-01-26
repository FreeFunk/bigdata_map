package com.edgedo.drawing.queryvo;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BigdataDriverCarPartitionFenxiQueueVo implements Serializable {
    //待处理分段
    private List<BigdataDriverCarPartitionCountDayView> partitionList;
    //车辆id
    private String carId ;
    //某天的数据
    private Integer dayInt;

    public List<BigdataDriverCarPartitionCountDayView> getPartitionList() {
        return partitionList;
    }

    public void setPartitionList(List<BigdataDriverCarPartitionCountDayView> partitionList) {
        this.partitionList = partitionList;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getDayInt() {
        return dayInt;
    }

    public void setDayInt(Integer dayInt) {
        this.dayInt = dayInt;
    }

    @Override
    public String toString() {
        return "BigdataDriverCarPartitionFenxiQueueVo{" +
                "partitionList=" + partitionList +
                ", carId='" + carId + '\'' +
                ", dayInt=" + dayInt +
                '}';
    }
}
