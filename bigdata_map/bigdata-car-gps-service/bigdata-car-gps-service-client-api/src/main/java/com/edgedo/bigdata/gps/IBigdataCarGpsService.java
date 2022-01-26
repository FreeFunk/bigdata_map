package com.edgedo.bigdata.gps;


import com.edgedo.bigdata.entity.BigdataCarRealtimeSimple;
import com.edgedo.bigdata.entity.BigdataCarTrailGps;

/**
 * @author WangZhen
 * @description 大数据定位查询api
 * @date 2020/4/8
 */
public interface IBigdataCarGpsService {

    /**
     * @Author WangZhen
     * @Description 根据车牌号查询定位地址
     * @Date 2020/4/10 15:18
     **/
    BigdataCarRealtimeSimple loadCarGps(String carPlateId);
    /**
     * @Author WangZhen
     * @Description 读取实时的位置文件内容
     * @Date 2020/4/26 10:21
     **/
    String loadRealGpsFileStr();
    /**
     * @Author WangZhen
     * @Description 加载文件流处理
     * @Date 2020/4/26 11:40
     **/
    void loadRealGpsFileStream(CallBackInputStreamInter callBack);

    /**
     * @Author WangZhen
     * @Description 将轨迹行数据转成简单的轨迹对象
     * @Date 2020/4/27 11:45
     **/
    BigdataCarTrailGps changeStrToGpsSimple(String line);


}

