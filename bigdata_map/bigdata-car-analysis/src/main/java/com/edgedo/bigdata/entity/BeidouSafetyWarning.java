package com.edgedo.bigdata.entity;

import io.swagger.models.auth.In;

import java.math.BigDecimal;

/**
 * @ClassName BeidouSafetyWarning
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/8/29 14:19
 **/
public class BeidouSafetyWarning {

    //必填,唯一,用于关联数据 报警主键
    private String bId;
    //终端设备编号
    private String deviceno;
    //终端SIM卡号
    private String sim;
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //速度
    private Double speed;
    //方向
    private Double direction;
    //开始时间
    private String starttime;
    //结束时间
    private String endtime;
    //车牌号
    private String carPlateNum;
    //车牌颜色
    private String carPlateColor;
    //驾驶员姓名
    private String driverName;
    //驾驶员身份证号
    private String driverCard;
    //报警类型
    private Integer warningType;
    //报警详情
    private String warningInfo;
    //处理结果
    private String detailInfo;
    //报警状态（开始、结束、处理）
    private String alarmState;
    //处理状态
    private String handleState;
    //处理方式（手动解除、下发短信、回拨电话）
    private String handleType;
    //处理时间，格式yyyymmddhhmmss
    private String handleTime;
    //处理人
    private String handlePeople;
//道路等级
    /*41000 高速公路,42000 国道,43000 主要大街、城市快速路,51000 省道,
    44000 主要道路,45000  次要道路,52000 乡公路,53000 县乡村内部道路
    54000 县乡村内部道路,47000 普通道路,49 非导航道路*/
    private String roadLevel;
    /**
     * 属性描述:道路限速值
     */
    private Double roadSpeedLimit;

    //报警时长(秒)
    private Integer alarmTimeSecond;

    public Integer getAlarmTimeSecond() {
        return alarmTimeSecond;
    }

    public void setAlarmTimeSecond(Integer alarmTimeSecond) {
        this.alarmTimeSecond = alarmTimeSecond;
    }

    public String getRoadLevel() {
        return roadLevel;
    }

    public void setRoadLevel(String roadLevel) {
        this.roadLevel = roadLevel;
    }

    public Double getRoadSpeedLimit() {
        return roadSpeedLimit;
    }

    public void setRoadSpeedLimit(Double roadSpeedLimit) {
        this.roadSpeedLimit = roadSpeedLimit;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public String getCarPlateColor() {
        return carPlateColor;
    }

    public void setCarPlateColor(String carPlateColor) {
        this.carPlateColor = carPlateColor;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverCard() {
        return driverCard;
    }

    public void setDriverCard(String driverCard) {
        this.driverCard = driverCard;
    }

    public Integer getWarningType() {
        return warningType;
    }

    public void setWarningType(Integer warningType) {
        this.warningType = warningType;
    }

    public String getWarningInfo() {
        return warningInfo;
    }

    public void setWarningInfo(String warningInfo) {
        this.warningInfo = warningInfo;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState;
    }

    public String getHandleState() {
        return handleState;
    }

    public void setHandleState(String handleState) {
        this.handleState = handleState;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getHandlePeople() {
        return handlePeople;
    }

    public void setHandlePeople(String handlePeople) {
        this.handlePeople = handlePeople;
    }


    //附件
    public static class BeidouSafetyWarningFile{
        //必填,唯一,用于关联数据
        private String bId;
        //车牌号
        private String carPlateNum;
        //车架号
        private String carFrameNum;
        //照片:picture 视频:video
        private String fileType;
        //文件名
        private String fileName;
        //附件路径
        private String fileUrl;

        public String getbId() {
            return bId;
        }

        public void setbId(String bId) {
            this.bId = bId;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getCarPlateNum() {
            return carPlateNum;
        }

        public void setCarPlateNum(String carPlateNum) {
            this.carPlateNum = carPlateNum;
        }

        public String getCarFrameNum() {
            return carFrameNum;
        }

        public void setCarFrameNum(String carFrameNum) {
            this.carFrameNum = carFrameNum;
        }
    }
}
