package com.edgedo.timetask;


import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.entity.BigdataBeidouCarTraceBkRec;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.service.BigdataBeidouCarMonthCheckService;
import com.edgedo.bigdata.service.BigdataBeidouCarTraceBkRecService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.IocUtil;
import com.edgedo.sys.service.SysConfigService;
import com.edgedo.util.CoordinateUtil;
import com.edgedo.util.ITask;
import com.edgedo.util.MultiThreadUtils;
import com.edgedo.util.ResultBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ZhaoSiDa
 * @Description //车辆轨迹中断或飘点记录
 * @Date 2019/8/17 14:09
 * @Param
 * @return
 **/
@Component
public class BigdataCarTraceBkRec implements ITask<ResultBean<String>, String> {

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void updateCarInfo(){
        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);
        SysConfigService sysConfigService =  IocUtil.getBean(SysConfigService.class);
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

        List<String> data = carInfoService.listAllVo();
        //点的路径
        String gpsUrl = sysConfigService.loadById("GPS_URL").getValue();
        String pointDistatce = sysConfigService.loadById("POINT_DISTATCE").getValue();
        String pointSecond = sysConfigService.loadById("POINT_SECOND").getValue();
        String pointSecond2 = sysConfigService.loadById("POINT_SECOND2").getValue();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date lastDate = calendar.getTime();
        String lastDateStr = sdfDateInt.format(lastDate);

        // 创建多线程处理任务
        MultiThreadUtils<String> threadUtils = MultiThreadUtils.newInstance(10);
        ITask<ResultBean<String>, String> bigdataCarTraceBkRec = new BigdataCarTraceBkRec();
        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("gpsUrl", gpsUrl);
        params.put("pointDistatce", pointDistatce);
        params.put("pointSecond", pointSecond);
        params.put("pointSecond2", pointSecond2);
        params.put("lastDateStr", lastDateStr);
        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(data, params, bigdataCarTraceBkRec);
    }

    @Override
    public ResultBean execute(String e, Map<String, Object> params) {
        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);
        BigdataBeidouCarTraceBkRecService bigdataBeidouCarTraceBkRecService = IocUtil.getBean(BigdataBeidouCarTraceBkRecService.class);
        BigdataBeidouCarMonthCheckService bigdataBeidouCarMonthCheckService = IocUtil.getBean(BigdataBeidouCarMonthCheckService.class);

        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        //查询车辆所属的运营商
        CarInfo carInfo = new CarInfo();
        carInfo.setCarPlateColour("2");
        carInfo.setCarPlateNum(e);
        carInfo = carInfoService.selectByCarPlateAndPlateColor(carInfo);
        //根据车牌号查询
        String lastDateStr = (String) params.get("lastDateStr");
        Integer dateInt = new Integer(lastDateStr);
        String gpsUrl = (String) params.get("gpsUrl");
        int pointDistatce = Integer.parseInt((String) params.get("pointDistatce")) ;
        int pointSecond = Integer.parseInt((String) params.get("pointSecond")) ;
        int pointSecond2 = Integer.parseInt((String) params.get("pointSecond2")) ;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("carPlate",e);
        param.put("searchDay",lastDateStr);
        HttpRequestUtil.HttpResuestResponseStreamWrap res = HttpRequestUtil.postRequestByte(gpsUrl,param);
        InputStream bis = res.getInputStream();
        InputStreamReader isr= null;
        try {
            isr = new InputStreamReader(bis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line="";
            List<BigdataCarRealtimeGps> bigdataCarRealtimeGpsList = new ArrayList<>();
            while ((line=br.readLine())!=null) {
                BigdataCarRealtimeGps bigdataCarRealtimeGps = fenxiOneRealPosition(line);
                bigdataCarRealtimeGpsList.add(bigdataCarRealtimeGps);
            }
            //根据时间过滤数据
            int k = 0;
            for(int i=0;i<bigdataCarRealtimeGpsList.size()-1;i++){
                BigdataCarRealtimeGps bigdataCarRealtimeGps1 =  bigdataCarRealtimeGpsList.get(i);
                Date lastPositionTime1 = bigdataCarRealtimeGps1.getLastPositionTime();
                BigDecimal pointLong1 =bigdataCarRealtimeGps1.getPointLong();
                BigDecimal pointLat1 = bigdataCarRealtimeGps1.getPointLat();

                BigdataCarRealtimeGps bigdataCarRealtimeGps2 =  bigdataCarRealtimeGpsList.get(i+1);
                Date lastPositionTime2 = bigdataCarRealtimeGps2.getLastPositionTime();
                BigDecimal pointLong2 =bigdataCarRealtimeGps2.getPointLong();
                BigDecimal pointLat2 = bigdataCarRealtimeGps2.getPointLat();
                long number = (lastPositionTime2.getTime()-lastPositionTime1.getTime())/1000;

                double distatce = CoordinateUtil.getDistatce(pointLong2.doubleValue(),pointLat2.doubleValue(),pointLong1.doubleValue(),pointLat1.doubleValue());
                //轨迹不完整
                if(number > pointSecond  && distatce > pointDistatce){
                    if(carInfo!=null){
                        BigdataBeidouCarTraceBkRec bigdataBeidouCarTraceBkRec = new BigdataBeidouCarTraceBkRec();
                        bigdataBeidouCarTraceBkRec.setCreateTime(new Date());
                        bigdataBeidouCarTraceBkRec.setCompId(carInfo.getComId());
                        bigdataBeidouCarTraceBkRec.setCompName(carInfo.getComName());
                        bigdataBeidouCarTraceBkRec.setCarPlateNum(carInfo.getCarPlateNum());
                        bigdataBeidouCarTraceBkRec.setCarFrameNum(carInfo.getCarFrameNum());
                        bigdataBeidouCarTraceBkRec.setStartTime(lastPositionTime1);
                        bigdataBeidouCarTraceBkRec.setEndTime(lastPositionTime2);
                        bigdataBeidouCarTraceBkRec.setStartLnLat(pointLong1+","+pointLat1);
                        bigdataBeidouCarTraceBkRec.setEndLnLat(pointLong2+","+pointLat2);
                        bigdataBeidouCarTraceBkRec.setPointDistance(new BigDecimal(distatce));
                        bigdataBeidouCarTraceBkRec.setBreakType("0");
                        bigdataBeidouCarTraceBkRec.setCountDate(dateInt);
                        bigdataBeidouCarTraceBkRec.setCountMonth(dateInt/100);
                        bigdataBeidouCarTraceBkRec.setYearNum(dateInt/10000);
                        bigdataBeidouCarTraceBkRecService.insert(bigdataBeidouCarTraceBkRec);
                    }
                }
                //轨迹漂移
                if(number < pointSecond2  && distatce > pointDistatce){
                    if(carInfo!=null){
                        BigdataBeidouCarTraceBkRec bigdataBeidouCarTraceBkRec = new BigdataBeidouCarTraceBkRec();
                        bigdataBeidouCarTraceBkRec.setCreateTime(new Date());
                        bigdataBeidouCarTraceBkRec.setCompId(carInfo.getComId());
                        bigdataBeidouCarTraceBkRec.setCompName(carInfo.getComName());
                        bigdataBeidouCarTraceBkRec.setCarPlateNum(carInfo.getCarPlateNum());
                        bigdataBeidouCarTraceBkRec.setCarFrameNum(carInfo.getCarFrameNum());
                        bigdataBeidouCarTraceBkRec.setStartTime(lastPositionTime1);
                        bigdataBeidouCarTraceBkRec.setEndTime(lastPositionTime2);
                        bigdataBeidouCarTraceBkRec.setStartLnLat(pointLong1+","+pointLat1);
                        bigdataBeidouCarTraceBkRec.setEndLnLat(pointLong2+","+pointLat2);
                        bigdataBeidouCarTraceBkRec.setPointDistance(new BigDecimal(distatce));
                        bigdataBeidouCarTraceBkRec.setBreakType("1");
                        bigdataBeidouCarTraceBkRec.setCountDate(dateInt);
                        bigdataBeidouCarTraceBkRec.setCountMonth(dateInt/100);
                        bigdataBeidouCarTraceBkRec.setYearNum(dateInt/10000);
                        bigdataBeidouCarTraceBkRecService.insert(bigdataBeidouCarTraceBkRec);
                    }
                }
                if(number>30){
                    k=k+1;
                }else {
                    k=0;
                }
                //计算回传间隔连续连着10个大于30秒
                if(k>=10){
                    if(carInfo!=null){
                        //更新回传间隔是否合格
                        BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck = new BigdataBeidouCarMonthCheck();
                        bigdataBeidouCarMonthCheck.setCarPlateNum(carInfo.getCarPlateNum());
                        bigdataBeidouCarMonthCheck.setCarFrameNum(carInfo.getCarFrameNum());
                        bigdataBeidouCarMonthCheck.setCarPlateColor(carInfo.getCarPlateColour());
                        bigdataBeidouCarMonthCheck.setCompId(carInfo.getComId());
                        bigdataBeidouCarMonthCheck.setCompName(carInfo.getComName());
                        bigdataBeidouCarMonthCheck.setCountDate(dateInt);
                        bigdataBeidouCarMonthCheck.setCountMonth(dateInt/100);
                        bigdataBeidouCarMonthCheck.setYearNum(dateInt/10000);
                        bigdataBeidouCarMonthCheck.setGpsUploadTimeQualifiedFlag("0");
                        bigdataBeidouCarMonthCheckService.insertOrUpdate(bigdataBeidouCarMonthCheck);
                    }
                }
            }
            //查询
            br.close();
            isr.close();
            bis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(e.toString());
        return resultBean;
    }

    public BigdataCarRealtimeGps fenxiOneRealPosition(String temLine){
        String[] arr = temLine.split(",");
        if(arr.length<13){
            return null;
        }
        String ip = arr[0];
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
        //车辆状态
        String carState = arr[10];
        //报警状态
        String alarmState = arr[11];
        //车牌颜色
        String carPlateColor = arr[12];

        BigdataCarRealtimeGps bigdataCarRealtimeGps = new BigdataCarRealtimeGps();
        bigdataCarRealtimeGps.setIp(ip);
        //冀CWL468
        int start = carPlateNum.length()-8;
        start = start>=0?start:0;
        bigdataCarRealtimeGps.setCarPlateNum(carPlateNum.substring(start));
        Date lastPostime = new Date();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lastPostime = sdf.parse(lastPositionTime);
            bigdataCarRealtimeGps.setLastPositionTime(lastPostime);
            bigdataCarRealtimeGps.setPointLat(new BigDecimal(pointLat));
            bigdataCarRealtimeGps.setPointLong(new BigDecimal(pointLong));
            bigdataCarRealtimeGps.setRealSpeed(new BigDecimal(realSpeed));
            bigdataCarRealtimeGps.setGpsSpeed(new BigDecimal(gpsSpeed));
            bigdataCarRealtimeGps.setMileage(new BigDecimal(mileage));
            bigdataCarRealtimeGps.setDirection(new BigDecimal(direction));
            bigdataCarRealtimeGps.setAltitude(new BigDecimal(altitude));
            bigdataCarRealtimeGps.setCarState(carState);
            bigdataCarRealtimeGps.setAlarmState(alarmState);
            bigdataCarRealtimeGps.setCarPlateColor(carPlateColor);
            bigdataCarRealtimeGps.setLastUpTime(new Date());
            return bigdataCarRealtimeGps;
        }catch (Exception e){

        }
        return null;

    }
}
