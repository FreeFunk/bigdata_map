package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.CountCarNum;
import com.edgedo.bigdata.entity.MapLocaltionPoint;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.bigdata.service.MapLocaltionPointService;
import com.edgedo.common.util.IocUtil;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysCityQuery;
import com.edgedo.sys.queryvo.SysCityView;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.queryvo.SysProviceView;
import com.edgedo.sys.service.SysCityService;
import com.edgedo.sys.service.SysProviceService;
import com.edgedo.sys.service.SysXianquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ConditionalOnProperty(
        value = {"timetask.analysis.UpdateMapPoint.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class UpdateMapPoint {

    @Autowired
    SysXianquService sysXianquService;
    @Autowired
    SysCityService sysCityService;
    @Autowired
    SysProviceService sysProviceService;

    //更新每个县区下的不同类型的车的数量
    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.UpdateMapPoint.cron.countByCarType}")
    public void countByCarType(){
        updeteXianQuCarNum("总");
        updeteXianQuCarNum("客运");
        updeteXianQuCarNum("危货");
        updeteXianQuCarNum("普货");
    }
    //更新每个县区下的车的数量
    public void updeteXianQuCarNum(String carType){

        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);

        MapLocaltionPointService mapLocaltionPointService = IocUtil.getBean(MapLocaltionPointService.class);
        //统计出各个县区下的车的数量
        List<CountCarNum> countCarNumList = new ArrayList<>();
        if(carType!=null && carType.equals("总")){
            countCarNumList= carInfoService.countCarNumByXianQuId("");
        }else {
            countCarNumList= carInfoService.countCarNumByXianQuId(carType);
        }
        if(countCarNumList!=null && countCarNumList.size()>0){
            //清空地图上县区的车的数量
            carInfoService.updateCarNum("XIANQU",carType);
        }
        //开始遍历
        try{
            for(CountCarNum carNum:countCarNumList){
                String xianquId = carNum.getXianquId();
                MapLocaltionPoint mapLocaltionPoint = mapLocaltionPointService.selectByXianQuId(xianquId,carType);
                if(mapLocaltionPoint!=null){
                    mapLocaltionPoint.setCarNum(carNum.getCarNum());
                    mapLocaltionPointService.update(mapLocaltionPoint);
                }else {
                    SysXianqu sysXianqu = sysXianquService.loadById(carNum.getXianquId());
                    if(sysXianqu!=null){
                        MapLocaltionPoint mapLocaltionPoint1 = new MapLocaltionPoint();
                        mapLocaltionPoint1.setProvinceId(sysXianqu.getProvinceId());
                        mapLocaltionPoint1.setProvinceName(sysXianqu.getProvinceName());
                        mapLocaltionPoint1.setCityId(sysXianqu.getCityId());
                        mapLocaltionPoint1.setCityName(sysXianqu.getCityName());
                        mapLocaltionPoint1.setXianquId(sysXianqu.getId());
                        mapLocaltionPoint1.setXianquName(sysXianqu.getName());
                        mapLocaltionPoint1.setCountType("XIANQU");
                        mapLocaltionPoint1.setCarNum(carNum.getCarNum());
                        mapLocaltionPoint1.setCarType(carType);
                        mapLocaltionPointService.insert(mapLocaltionPoint1);
                    }else {
                        System.out.println(carNum.getXianquName()+"不存在！");
                    }
                }
            }
            updateCityCarNum(carType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //根据县区统计城市下面的车的数量
    public void updateCityCarNum(String carType){

        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);
        //清空地图上城市的车的数量
        carInfoService.updateCarNum("CITY",carType);

        MapLocaltionPointService mapLocaltionPointService = IocUtil.getBean(MapLocaltionPointService.class);

        SysCityQuery sysCityQuery = new SysCityQuery();
        //获取所有的城市遍历统计
        List<SysCityView> sysCityViewList = sysCityService.listByObj(sysCityQuery);
        for(SysCityView city:sysCityViewList){
            String cityId = city.getId();
            MapLocaltionPoint mapLocaltionPoint = mapLocaltionPointService.selectByCityId(cityId,carType);
            if(mapLocaltionPoint!=null){
                Integer countCarNumByCityId = mapLocaltionPointService.countCarNumByCityId(cityId,carType);
                mapLocaltionPoint.setCarNum(countCarNumByCityId);
                mapLocaltionPointService.update(mapLocaltionPoint);
            }else {
                System.out.println(city.getName()+"====城市不存在！");
            }
        }
        //获取所有的省份
        SysProviceQuery sysProviceQuery = new SysProviceQuery();
        //清空地图上城市的车的数量
        carInfoService.updateCarNum("PROVINCE",carType);
        List<SysProviceView> sysProviceViewList = sysProviceService.selectAll(sysProviceQuery);
        for(SysProviceView provice:sysProviceViewList){
            String proviceId = provice.getId();
            MapLocaltionPoint mapLocaltionPoint = mapLocaltionPointService.selectByProviceId(proviceId,carType);
            if(mapLocaltionPoint!=null){
                Integer countCarNumByProviceId = mapLocaltionPointService.countCarNumByProviceId(proviceId,carType);
                mapLocaltionPoint.setCarNum(countCarNumByProviceId);
                mapLocaltionPointService.update(mapLocaltionPoint);
            }
        }
    }
}
