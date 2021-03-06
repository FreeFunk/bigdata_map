package com.edgedo.timetask.analysis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BeidouSafetyCarInfo;
import com.edgedo.bigdata.service.BigdataBeidouSafetyCarInfoService;
import com.edgedo.common.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigDataTongBuRedTreeCarInfo.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataTongBuRedTreeCarInfo {

    @Value("${TongBuCarInfoUrl}")
    String TongBuCarInfoUrl;

    @Value("${gpsCompId}")
    String gpsCompId;

    //车辆信息
    @Autowired
    BigdataBeidouSafetyCarInfoService bigdataBeidouSafetyCarInfoService;


    /*public static void main(String[] args) {
        String url =  "http://39.106.199.153:6013/carinfo?userid=123456&userkey=123456&lastupdatetime=20190730010101" ;
        String res = HttpRequestUtil.sendPostRequest(url,new HashMap<String,String>());
        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray carInfoArr = (JSONArray)jsonObject.get("carInfo");
        List<RedTreeCarInfo> carList =  carInfoArr.toJavaList(RedTreeCarInfo.class);
        for(RedTreeCarInfo carInfo : carList ){
            System.out.println(carInfo);
        }
    }*/

    //1个小时同步一次
    //@Scheduled(cron = "0 51 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataTongBuRedTreeCarInfo.cron.tongbuCarInfo}")
   // @Scheduled(cron = "0/2 * * * * ? *")
    public void tongbuCarInfo(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //查询两个小时内的数据
        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.HOUR,-2);
//        cal.add(Calendar.MONTH,-1);
        cal.add(Calendar.DAY_OF_MONTH,-2);
        Date upTime = cal.getTime();
        String lastupdatetime =  sdf.format(upTime);
        String url = TongBuCarInfoUrl + "&lastupdatetime=" + lastupdatetime;
        String res = HttpRequestUtil.sendPostRequest(url,new HashMap<String,String>());
        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray carInfoArr = (JSONArray)jsonObject.get("carInfo");
        List<RedTreeCarInfo> carList =  carInfoArr.toJavaList(RedTreeCarInfo.class);
        List<BeidouSafetyCarInfo> safetyCarInfoList = new ArrayList<BeidouSafetyCarInfo>();
        for(RedTreeCarInfo carInfo : carList ){
            String delete = carInfo.getDelete()+"";
            if(delete.equals("true")){
                continue;
            }
            BeidouSafetyCarInfo beidouSafetyCarInfo  = new BeidouSafetyCarInfo();
            beidouSafetyCarInfo.setCarPlateColor(carInfo.getVehicle_color()+"");
            beidouSafetyCarInfo.setCarPlateNum(carInfo.getVehicle_no());
            //设备id
            beidouSafetyCarInfo.setModelId(carInfo.getDevice_no());
            //SIM卡号
            beidouSafetyCarInfo.setSim(carInfo.getSim());
            //允许打开的通道
            beidouSafetyCarInfo.setChannelEnable(carInfo.getChn_enable());
            String protocal = carInfo.getProtocol();

            beidouSafetyCarInfo.setProtocol(changeProtocalNoToReal(protocal));
            try {
                //通道数量
                beidouSafetyCarInfo.setChannelNum(new Integer(carInfo.getChn_num()));
            }catch (Exception e){}

            //TODO: 缺失安装时间
            beidouSafetyCarInfo.setInstallTime(null);
            //TODO: 缺失设备型号
//            beidouSafetyCarInfo.setModelCode("D5X");
            //TODO: 缺失设备制造商
//            beidouSafetyCarInfo.setManufacturerName("深圳市瑞明技术股份有限公司");

            safetyCarInfoList.add(beidouSafetyCarInfo);
        }

        bigdataBeidouSafetyCarInfoService.updateSafetyCarInfo(safetyCarInfoList,gpsCompId);


    }


    private String changeProtocalNoToReal(String no){
        if(no==null){
            return no;
        }
//        0 808, 1 1078, 2 n9m, 3 cms, 4 地标
        switch (no){
            case  "0" :  return  "808" ;
            case  "1" :  return  "1078";
            case  "2" :  return  "n9m" ;
            case  "3" :  return  "cms" ;
            case  "4" :  return  "地标";
        }
        return no;
    }


    public static class RedTreeCarInfo{
        //车牌颜色
        private Integer vehicle_color;
        //协议类型0=808, 1=1078, 2=n9m, 3=cms, 4=地标
        private String protocol;
        //目测应该是视频通道
        private String chn_enable;
        //sim卡号
        private String sim;
        //车牌号
        private String vehicle_no;
        //不知道是啥
        private String imei;
        //设备id
        private String device_no;
        //通道数量
        private String chn_num;
        //主键
        private String vehicle_id;
        //企业
        private String group;
        //是否删除
        private Boolean delete;

        public Boolean getDelete() {
            return delete;
        }

        public void setDelete(Boolean delete) {
            this.delete = delete;
        }

        public Integer getVehicle_color() {
            return vehicle_color;
        }

        public void setVehicle_color(Integer vehicle_color) {
            this.vehicle_color = vehicle_color;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getChn_enable() {
            return chn_enable;
        }

        public void setChn_enable(String chn_enable) {
            this.chn_enable = chn_enable;
        }

        public String getSim() {
            return sim;
        }

        public void setSim(String sim) {
            this.sim = sim;
        }

        public String getVehicle_no() {
            return vehicle_no;
        }

        public void setVehicle_no(String vehicle_no) {
            this.vehicle_no = vehicle_no;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getDevice_no() {
            return device_no;
        }

        public void setDevice_no(String device_no) {
            this.device_no = device_no;
        }

        public String getChn_num() {
            return chn_num;
        }

        public void setChn_num(String chn_num) {
            this.chn_num = chn_num;
        }

        public String getVehicle_id() {
            return vehicle_id;
        }

        public void setVehicle_id(String vehicle_id) {
            this.vehicle_id = vehicle_id;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return "RedTreeCarInfo{" +
                    "vehicle_color=" + vehicle_color +
                    ", protocol='" + protocol + '\'' +
                    ", chn_enable='" + chn_enable + '\'' +
                    ", sim='" + sim + '\'' +
                    ", vehicle_no='" + vehicle_no + '\'' +
                    ", imei='" + imei + '\'' +
                    ", device_no='" + device_no + '\'' +
                    ", chn_num='" + chn_num + '\'' +
                    ", vehicle_id='" + vehicle_id + '\'' +
                    ", group='" + group + '\'' +
                    '}';
        }
    }

}
