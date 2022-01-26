package com.edgedo.bigdata.gps;

import com.edgedo.bigdata.entity.BigdataCarRealtimeSimple;
import com.edgedo.bigdata.entity.BigdataCarTrailGps;
import com.edgedo.common.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/**
 * @author WangZhen
 * @description 客户端调用发短信公共服务的api接口
 * @date 2020/4/8
 */
/**
 * @author WangZhen
 * @description
 * @date 2020/4/8
 */
@ConditionalOnProperty(
        value = {"app.bigdataCarGpsServiceUrl"},
        matchIfMissing = false
)
@Service
public class BigdataCarGpsService implements IBigdataCarGpsService {
    //url 地址
    @Value("${app.bigdataCarGpsServiceUrl}")
    String bigdataCarGpsServiceUrl;
    //请求工具
    @Autowired
    RestTemplate restTemplate;

    @Override
    public BigdataCarRealtimeSimple loadCarGps(String carPlateId) {
        String url = bigdataCarGpsServiceUrl + "/cartrail/loadCarGps.jsn";
        return restTemplate.postForObject(url,carPlateId,BigdataCarRealtimeSimple.class);
    }

    @Override
    public String loadRealGpsFileStr() {
        String url = bigdataCarGpsServiceUrl + "/cartrail/loadRealGpsFileStr.jsn";
        return restTemplate.getForObject(url,String.class);
    }

    @Override
    public void loadRealGpsFileStream(CallBackInputStreamInter callBack) {
        String url = bigdataCarGpsServiceUrl + "/cartrail/loadRealGpsFileStream.jsn";
        HttpRequestUtil.HttpResuestResponseStreamWrap res =
                HttpRequestUtil.postRequestByte(url,new HashMap<>());
        InputStream bis = res.getInputStream();
        try {
            callBack.callBack(bis);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public BigdataCarTrailGps changeStrToGpsSimple(String line) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] arr = line.split(",");
        if(arr.length<13){
            return null;
        }
        //车牌号
        String carPlateNum = arr[1];
        //上次的更新时间
        String lastPositionTime = arr[2];
        //经度
        String pointLong = arr[3];
        //纬度
        String pointLat = arr[4] ;
        //实时速度
        String realSpeed = arr[5];
        //gps速度
        String gpsSpeed = arr[6];
        //里程
        String mileage = arr[7];
        //方向
        String direction = arr[8];
        //海拔
        String altitude = arr[9];
        //车牌颜色
        String carPlateColor = arr[12];
        if(carPlateColor!=null && carPlateColor.length()>1){
            return null;
        }
        if(arr.length==14){
            lastPositionTime = arr[13];
        }

        BigdataCarTrailGps bigdataCarGps = new BigdataCarTrailGps();
        //先把配置的特殊符号去掉
        bigdataCarGps.setCarPlateNum(trimCarPlateNum(carPlateNum));
        try{
            Date lastPostime = sdf.parse(lastPositionTime);
            bigdataCarGps.setLastPositionTime(lastPostime);
            bigdataCarGps.setPointLat(new BigDecimal(pointLat));
            bigdataCarGps.setPointLong(new BigDecimal(pointLong));
            bigdataCarGps.setRealSpeed(new BigDecimal(realSpeed));
            bigdataCarGps.setGpsSpeed(new BigDecimal(gpsSpeed));
            bigdataCarGps.setMileage(new BigDecimal(mileage));
            bigdataCarGps.setDirection(new BigDecimal(direction));
            bigdataCarGps.setAltitude(new BigDecimal(altitude));
            bigdataCarGps.setCarPlateColor(carPlateColor);
            return bigdataCarGps;
        }catch (Exception e){}
        return null;
    }


    /**
     * 去掉车牌号的特殊字符
     * @param carPlateNum
     * @return
     */
    private String trimCarPlateNum(String carPlateNum){
        if(carPlateNum!=null){
            carPlateNum = carPlateNum.replaceAll("[- _ #]","");
            carPlateNum = carPlateNum.replaceAll(" ","");
        }
        return carPlateNum;
    }


}
