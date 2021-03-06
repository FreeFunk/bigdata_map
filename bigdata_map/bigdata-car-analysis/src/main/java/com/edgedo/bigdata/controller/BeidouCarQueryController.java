package com.edgedo.bigdata.controller;

import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataCarRealtimeSimple;
import com.edgedo.bigdata.service.BigdataCarRealtimeGpsService;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/carQuery")
public class BeidouCarQueryController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    BigdataCarRealtimeGpsService gpsService;

    /**
     * 查询实时的定位信息
     */
    @RequestMapping(value = "/searchRealLocation")
    public ModelAndView loadCarTrail(String ids){
        ModelAndView modelAndView = new ModelAndView();
        Map<String,BigdataCarRealtimeSimple> result = new HashMap<String,BigdataCarRealtimeSimple>();
        Map<String,BigdataCarRealtimeGps> temMap = new HashMap<String,BigdataCarRealtimeGps>();
        if(ids == null || ids.length()==0){buildResponse(modelAndView);}
        String[] carPlateIdArr = ids.split(",");
        //查询gps数据库表中的记录
        List<BigdataCarRealtimeGps> list = gpsService.selectCarGpsInfoByIds(carPlateIdArr);
        for(BigdataCarRealtimeGps dbGps : list){
            temMap.put(dbGps.getId(),dbGps);
        }
        for(String carPlagetId : carPlateIdArr){
            BigdataCarRealtimeGps gps =  (BigdataCarRealtimeGps)redisUtil.hget(
                    RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY,carPlagetId);
            if(gps==null){
                gps = temMap.get(carPlagetId);
            }
            if(gps!=null){
                BigdataCarRealtimeSimple gpsSimple = new BigdataCarRealtimeSimple();
                gpsSimple.setId(gps.getId());
                gpsSimple.setAltitude(gps.getAltitude());
                gpsSimple.setDirection(gps.getDirection());
                gpsSimple.setErrMsg(gps.getErrMsg());
                gpsSimple.setQualifiedState(gps.getQualifiedState());
                gpsSimple.setGpsSpeed(gps.getGpsSpeed());
                gpsSimple.setRealSpeed(gps.getRealSpeed());
                gpsSimple.setLastPositionTime(gps.getLastPositionTime());
                gpsSimple.setOnlineState(gps.getOnlineState());
                gpsSimple.setPointLat(gps.getPointLat());
                gpsSimple.setPointLong(gps.getPointLong());
                gpsSimple.setTodayMileageTotal(gps.getTodayMileageTotal());
                gpsSimple.setTodayTimeTotal(gps.getTodayTimeTotal());
                result.put(carPlagetId,gpsSimple);
            }
        }

        return buildResponse(modelAndView,result);



    }

    /**
     * 测试同步车辆
     */
    /*@RequestMapping(value = "/synCarLocationInfoGps")
    public ModelAndView synCarLocationInfoGps(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            //如果时间在凌晨0点 5分之前返回
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minu = cal.get(Calendar.MINUTE);
            int temNum = hour * 10 + minu;
            if (temNum <= 5) {
                return modelAndView;
            }

            String gpsCarRedsMapKey = RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY;
            Map<Object,Object> carMap = redisUtil.hmget(gpsCarRedsMapKey);
            Collection<Object> values = carMap.values();
            List<BigdataCarRealtimeGps> list0 = new ArrayList<BigdataCarRealtimeGps>();
            List<BigdataCarRealtimeGps> list1 = new ArrayList<BigdataCarRealtimeGps>();
            List<BigdataCarRealtimeGps> list2 = new ArrayList<BigdataCarRealtimeGps>();
            List<BigdataCarRealtimeGps> list3 = new ArrayList<BigdataCarRealtimeGps>();
            List<BigdataCarRealtimeGps> list4 = new ArrayList<BigdataCarRealtimeGps>();
            for(Object obj : values){
                if(obj instanceof BigdataCarRealtimeGps){
                    BigdataCarRealtimeGps gps =  (BigdataCarRealtimeGps)obj;
                    String carPlateNum = gps.getCarPlateNum();
                    String lastStr =  carPlateNum.substring(carPlateNum.length()-1);
                    if(lastStr.equals("0")||lastStr.equals("5")){
                        list0.add(gps);
                    }else if(lastStr.equals("1")||lastStr.equals("9")){
                        list1.add(gps);
                    }else if(lastStr.equals("2")||lastStr.equals("8")){
                        list2.add(gps);
                    }else if(lastStr.equals("3")||lastStr.equals("7")){
                        list3.add(gps);
                    }else if(lastStr.equals("4")||lastStr.equals("6")){
                        list4.add(gps);
                    }else{
                        list0.add(gps);
                    }
//                    gpsService.insertOrUpdate((BigdataCarRealtimeGps)obj);
                }
            }
            new DealGpsListTread(list0,gpsService).start();
            new DealGpsListTread(list1,gpsService).start();
            new DealGpsListTread(list2,gpsService).start();
            new DealGpsListTread(list3,gpsService).start();
            new DealGpsListTread(list4,gpsService).start();





        }catch (Exception e){
            e.printStackTrace();
        }

        return buildResponse(modelAndView);
    }

    static class DealGpsListTread extends Thread{
        private List<BigdataCarRealtimeGps> dataList;
        private BigdataCarRealtimeGpsService service;


        public DealGpsListTread(List<BigdataCarRealtimeGps> dataList, BigdataCarRealtimeGpsService service) {
            this.dataList = dataList;
            this.service = service;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for(BigdataCarRealtimeGps gps : dataList){
                service.insertOrUpdate(gps);
            }
            long end = System.currentTimeMillis();
            System.out.println("用时:" + ((end-start)/1000));

        }

        public List<BigdataCarRealtimeGps> getDataList() {
            return dataList;
        }

        public void setDataList(List<BigdataCarRealtimeGps> dataList) {
            this.dataList = dataList;
        }

        public BigdataCarRealtimeGpsService getService() {
            return service;
        }

        public void setService(BigdataCarRealtimeGpsService service) {
            this.service = service;
        }
    }*/

}
