package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;
import com.edgedo.bigdata.mapper.BigdataFenxiCountMapper;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * //    大数据分析概况
 * //    天(DAY) 周(WEEK) 月(MONTH)
 * //    总(总) 客运(客运) 危货(危货) 普货(普货)
 * //    区域统计类型 县区 城市
 * //    一条记录对应一个统计日期
 * //    一条记录对应一个车辆类型
 * //    一条记录对应一个区域类型
 * //    天数统计到7天集合成一周
 * //    天数统计到30天集合成一个月
 * //    一个县区统计天周月
 * //    多个县区上升到市统计
 */
@Component
public class BigdataFenXiCount {
    @Autowired
    private BigdataTimeCarDayRecMapper bigdataTimeCarDayRecMapper;
    @Autowired
    private BigdataFenxiCountMapper bigdataFenxiCountMapper;
    @Autowired
    private BigdataTimeCarDayRecService bigdataTimeCarDayRecService;

    @Scheduled(cron = "0 15 3 * * ?")//0 0 10 * * ?每天十点  0/2 * * * * ? 0 0 1 * * ?
    public void countInfo(){
        //设置日期
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        //行驶里程
        //时间确定 DAY 20191008 201910 2019
        List<BigdataTimeCarDayRec> list = bigdataTimeCarDayRecMapper.selectByDate(yearNum,countMonth,countDay);
        List<BigdataTimeCarDayRec> listHaiGangQu = new ArrayList<>();//海港区
        List<BigdataTimeCarDayRec> listShanHaiGuang = new ArrayList<>();//山海关区
        List<BigdataTimeCarDayRec> listBeiDaiHe = new ArrayList<>();//北戴河区
        List<BigdataTimeCarDayRec> listFuNing = new ArrayList<>();//抚宁区
        List<BigdataTimeCarDayRec> listQingLong = new ArrayList<>();//青龙县
        List<BigdataTimeCarDayRec> listChangLi = new ArrayList<>();//昌黎县
        List<BigdataTimeCarDayRec> listLuLong = new ArrayList<>();//卢龙县
        List<BigdataTimeCarDayRec> listKaiFaQu = new ArrayList<>();//开发区
        //区域
        for(BigdataTimeCarDayRec bigdataTimeCarDayRec : list){
            if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("海港区")){
                listHaiGangQu.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("山海关区")){
                listShanHaiGuang.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("北戴河区")){
                listBeiDaiHe.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("抚宁区")){
                listFuNing.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("青龙县")){
                listQingLong.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("昌黎县")){
                listChangLi.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("卢龙县")){
                listLuLong.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getXianquName()!=null && bigdataTimeCarDayRec.getXianquName().equals("开发区")){
                listKaiFaQu.add(bigdataTimeCarDayRec);
            }
        }
        //车辆类型 客运(客运) 危货(危货) 普货(普货)三个类型
        Map<String,List<BigdataTimeCarDayRec>> mapHaiGangQu = getMap(listHaiGangQu);
        setBigdataInfo(mapHaiGangQu);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listHaiGangQu);
        Map<String,List<BigdataTimeCarDayRec>> mapShanHaiGuang = getMap(listShanHaiGuang);
        setBigdataInfo(mapShanHaiGuang);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listShanHaiGuang);
        Map<String,List<BigdataTimeCarDayRec>> mapBeiDaiHe = getMap(listBeiDaiHe);
        setBigdataInfo(mapBeiDaiHe);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listBeiDaiHe);
        Map<String,List<BigdataTimeCarDayRec>> mapFuNing = getMap(listFuNing);
        setBigdataInfo(mapFuNing);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listFuNing);
        Map<String,List<BigdataTimeCarDayRec>> mapQingLong = getMap(listQingLong);
        setBigdataInfo(mapQingLong);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listQingLong);
        Map<String,List<BigdataTimeCarDayRec>> mapChangLi = getMap(listChangLi);
        setBigdataInfo(mapChangLi);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listChangLi);
        Map<String,List<BigdataTimeCarDayRec>> mapLuLong = getMap(listLuLong);
        setBigdataInfo(mapLuLong);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listLuLong);
        Map<String,List<BigdataTimeCarDayRec>> mapKaiFaQu = getMap(listKaiFaQu);
        setBigdataInfo(mapKaiFaQu);
        //县区统计所有
        countXianQuAllInfo(yearNum,countMonth,countDay,dateStr,listKaiFaQu);
        //行驶时长
        //市各个车辆类型统计
        Map<String,List<BigdataTimeCarDayRec>> listAll = getMap(list);
        queryCarType(yearNum,countMonth,countDay,dateStr,listAll);
        //一天全部 县区三个车辆类型的统计 总的车辆  市三个
        setAllInfo(yearNum,countMonth,countDay,dateStr);
    }

    //市各个车辆类型统计
    private void queryCarType(Integer yearNum, Integer countMonth,Integer countDay,String dateStr,Map<String, List<BigdataTimeCarDayRec>> listAll) {
        //listPuHuo listKeYun listWeiHuo
        List<BigdataTimeCarDayRec> listPuHuo = listAll.get("listPuHuo");
        List<BigdataTimeCarDayRec> listKeYun = listAll.get("listKeYun");
        List<BigdataTimeCarDayRec> listWeiHuo = listAll.get("listWeiHuo");
        setCarTypeAll(listPuHuo,yearNum,countMonth,countDay,dateStr,"普货");
        setCarTypeAll(listKeYun,yearNum,countMonth,countDay,dateStr,"客运");
        setCarTypeAll(listWeiHuo,yearNum,countMonth,countDay,dateStr,"危货");
    }

    private void setCarTypeAll(List<BigdataTimeCarDayRec> list, Integer yearNum, Integer countMonth, Integer countDay, String dateStr,String carType) {
        BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
        Map<String,Object> map = bigdataTimeCarDayRecService.selectCountNum(carType,"",yearNum,countMonth,countDay);
        //行驶时长
        BigDecimal shiChang = (BigDecimal) map.get("runTimeLength");
        //行驶里程
        BigDecimal liCheng = (BigDecimal) map.get("runMileage");
        BigDecimal changGuiBaoJing = (BigDecimal) map.get("commonAlarmNum");//常规报警数量
        BigDecimal changGuiChuLi = (BigDecimal) map.get("commonHandleNum");//常规处理数量
        BigDecimal zhuDongAnQuanBaoJing = (BigDecimal) map.get("safeAlarmNum");//主动安全报警数量
        BigDecimal zhuDongAnQuanChuLi = (BigDecimal) map.get("safeHandleNum");//主动安全处理数量
        bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing.intValue());
        bigdataFenxiCount.setCommonHandleNum(changGuiChuLi.intValue());
        bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi.intValue());
        bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing.intValue());
        bigdataFenxiCount.setId(Guid.guid());//主键
        bigdataFenxiCount.setRunTimeLengthHour(shiChang.divide(new BigDecimal(60),2, RoundingMode.HALF_UP));//时长
        bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
        bigdataFenxiCount.setCreateTime(new Date());//创建时间
        bigdataFenxiCount.setProvinceId("HEBEI");//省
        bigdataFenxiCount.setProvinceName("河北省");
        bigdataFenxiCount.setCityId("130300");//市
        bigdataFenxiCount.setCityName("秦皇岛市");
        bigdataFenxiCount.setCountType("CITY");//区域统计类型
        bigdataFenxiCount.setTimeType("DAY");//时间类型
        bigdataFenxiCount.setCarType(carType);//车辆类型
        bigdataFenxiCount.setCountDate(countDay);//日
        bigdataFenxiCount.setCountMonth(countMonth);//月
        bigdataFenxiCount.setYearNum(yearNum);//年

        bigdataFenxiCount.setAlarmCarNum(bigdataTimeCarDayRecMapper.selectAlarmNum(countDay,countMonth,yearNum,carType));//报警车辆数
        bigdataFenxiCount.setAlarmCompNum(bigdataTimeCarDayRecMapper.selectCompNum(countDay,countMonth,yearNum,carType));//报警企业
        int flag = bigdataFenxiCountMapper.selectByInfoDay("",carType,countDay,countMonth,yearNum,"CITY","DAY");
        if(flag!=0){
            bigdataFenxiCount.setUpdateTime(new Date());
            bigdataFenxiCountMapper.updateByInfo(bigdataFenxiCount);
        }else {
            bigdataFenxiCountMapper.insert(bigdataFenxiCount);
        }
    }

    //统计全部
    public void setAllInfo(Integer yearNum, Integer countMonth,Integer countDay,String dateStr){
        //查询当天的所有信息
        BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
        Map<String,Object> map = bigdataTimeCarDayRecService.selectCountNum("","",yearNum,countMonth,countDay);
        //行驶时长
        BigDecimal shiChang = (BigDecimal) map.get("runTimeLength");
        //行驶里程
        BigDecimal liCheng = (BigDecimal) map.get("runMileage");
        BigDecimal changGuiBaoJing = (BigDecimal) map.get("commonAlarmNum");//常规报警数量
        BigDecimal changGuiChuLi = (BigDecimal) map.get("commonHandleNum");//常规处理数量
        BigDecimal zhuDongAnQuanBaoJing = (BigDecimal) map.get("safeAlarmNum");//主动安全报警数量
        BigDecimal zhuDongAnQuanChuLi = (BigDecimal) map.get("safeHandleNum");//主动安全处理数量
        bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing.intValue());
        bigdataFenxiCount.setCommonHandleNum(changGuiChuLi.intValue());
        bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi.intValue());
        bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing.intValue());
        bigdataFenxiCount.setId(Guid.guid());//主键
        bigdataFenxiCount.setRunTimeLengthHour(shiChang);//时长
        bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
        bigdataFenxiCount.setCreateTime(new Date());//创建时间
        bigdataFenxiCount.setProvinceId("HEBEI");//省
        bigdataFenxiCount.setProvinceName("河北省");
        bigdataFenxiCount.setCityId("130300");//市
        bigdataFenxiCount.setCityName("秦皇岛市");
        bigdataFenxiCount.setCountType("CITY");//区域统计类型
        bigdataFenxiCount.setTimeType("DAY");//时间类型
        bigdataFenxiCount.setCarType("总");//车辆类型
        bigdataFenxiCount.setCountDate(countDay);//日
        bigdataFenxiCount.setCountMonth(countMonth);//月
        bigdataFenxiCount.setYearNum(yearNum);//年
        bigdataFenxiCount.setAlarmCarNum(bigdataTimeCarDayRecMapper.selectAlarmNum(countDay,countMonth,yearNum,""));//报警车辆数
        bigdataFenxiCount.setAlarmCompNum(bigdataTimeCarDayRecMapper.selectCompNum(countDay,countMonth,yearNum,""));//报警企业
        int flag = bigdataFenxiCountMapper.selectByInfoDay("","总",countDay,countMonth,yearNum,"CITY","DAY");
        if(flag!=0){
            bigdataFenxiCount.setUpdateTime(new Date());
            bigdataFenxiCountMapper.updateByInfo(bigdataFenxiCount);
        }else {
            bigdataFenxiCountMapper.insert(bigdataFenxiCount);
        }
    }

    //上升到数据库
    private void setBigdataInfo(Map<String, List<BigdataTimeCarDayRec>> mapHaiGangQu) {
        //listPuHuo listKeYun listWeiHuo
        List<BigdataTimeCarDayRec> listPuHuo = mapHaiGangQu.get("listPuHuo");
        List<BigdataTimeCarDayRec> listKeYun = mapHaiGangQu.get("listKeYun");
        List<BigdataTimeCarDayRec> listWeiHuo = mapHaiGangQu.get("listWeiHuo");
        setPuHuo(listPuHuo,
                "普货",
                listPuHuo.get(0).getProvinceId(),
                listPuHuo.get(0).getProvinceName(),
                listPuHuo.get(0).getCityId(),
                listPuHuo.get(0).getCityName(),
                listPuHuo.get(0).getXianquId(),listPuHuo.get(0).getXianquName());
        setPuHuo(listKeYun,"客运",listPuHuo.get(0).getProvinceId(),
                listPuHuo.get(0).getProvinceName(),
                listPuHuo.get(0).getCityId(),
                listPuHuo.get(0).getCityName(),
                listPuHuo.get(0).getXianquId(),listPuHuo.get(0).getXianquName());
        setPuHuo(listWeiHuo,"危货",listPuHuo.get(0).getProvinceId(),
                listPuHuo.get(0).getProvinceName(),
                listPuHuo.get(0).getCityId(),
                listPuHuo.get(0).getCityName(),
                listPuHuo.get(0).getXianquId(),listPuHuo.get(0).getXianquName());
    }

    //县区统计所有的车辆类型
    private void countXianQuAllInfo(Integer yearNum,Integer countMonth,Integer countDay,String dateStr,List<BigdataTimeCarDayRec> list) {
        BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
        Map<String,Object> map = bigdataTimeCarDayRecService.selectCountNum("",list.get(0).getXianquId(),yearNum,countMonth,countDay);
        //行驶时长
        BigDecimal shiChang = (BigDecimal) map.get("runTimeLength");
        //行驶里程
        BigDecimal liCheng = (BigDecimal) map.get("runMileage");
        BigDecimal changGuiBaoJing = (BigDecimal) map.get("commonAlarmNum");//常规报警数量
        BigDecimal changGuiChuLi = (BigDecimal) map.get("commonHandleNum");//常规处理数量
        BigDecimal zhuDongAnQuanBaoJing = (BigDecimal) map.get("safeAlarmNum");//主动安全报警数量
        BigDecimal zhuDongAnQuanChuLi = (BigDecimal) map.get("safeHandleNum");//主动安全处理数量
        bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing.intValue());
        bigdataFenxiCount.setCommonHandleNum(changGuiChuLi.intValue());
        bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi.intValue());
        bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing.intValue());
        bigdataFenxiCount.setId(Guid.guid());//主键
        bigdataFenxiCount.setRunTimeLengthHour(shiChang.divide(new BigDecimal(60),2, RoundingMode.HALF_UP));//时长
        bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
        bigdataFenxiCount.setCreateTime(new Date());//创建时间
        bigdataFenxiCount.setProvinceId(list.get(0).getProvinceId());//省
        bigdataFenxiCount.setProvinceName(list.get(0).getProvinceName());
        bigdataFenxiCount.setCityId(list.get(0).getCityId());//市
        bigdataFenxiCount.setCityName(list.get(0).getCityName());
        bigdataFenxiCount.setXianquId(list.get(0).getXianquId());//县区
        bigdataFenxiCount.setXianquName(list.get(0).getXianquName());
        bigdataFenxiCount.setCountType("XIANQU");//区域统计类型
        bigdataFenxiCount.setTimeType("DAY");//时间类型
        bigdataFenxiCount.setCarType("总");//车辆类型
        bigdataFenxiCount.setCountDate(countDay);//日
        bigdataFenxiCount.setCountMonth(countMonth);//月
        bigdataFenxiCount.setYearNum(yearNum);//年
        bigdataFenxiCount.setAlarmCarNum(bigdataTimeCarDayRecMapper.selectAlarmNumXianQuAll(list.get(0).getXianquId(),countDay,countMonth,yearNum));//报警车辆数
        bigdataFenxiCount.setAlarmCompNum(bigdataTimeCarDayRecMapper.selectCompNumXianQuAll(list.get(0).getXianquId(),countDay,countMonth,yearNum));//报警企业数
        int flag = bigdataFenxiCountMapper.selectByInfoDay(list.get(0).getXianquId(),"总",countDay,countMonth,yearNum,"XIANQU","DAY");
        if(flag!=0){
            bigdataFenxiCount.setUpdateTime(new Date());
            bigdataFenxiCountMapper.updateByInfo(bigdataFenxiCount);
        }else {
            bigdataFenxiCountMapper.insert(bigdataFenxiCount);
        }

    }

    private void setPuHuo(List<BigdataTimeCarDayRec> listPuHuo,
                          String carType,String provinceId,String provinceName,
                          String cityId,String cityName,
                          String xianQuId,String xianQuName) {
        //设置日期
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
        Map<String,Object> map = bigdataTimeCarDayRecService.selectCountNum(carType,xianQuId,yearNum,countMonth,countDay);
        if(map==null){
            bigdataFenxiCount.setCommonAlarmNum(0);
            bigdataFenxiCount.setCommonHandleNum(0);
            bigdataFenxiCount.setSafeHandleNum(0);
            bigdataFenxiCount.setSafeAlarmNum(0);
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(new BigDecimal(0));//时长
            bigdataFenxiCount.setRunMileage(new BigDecimal(0));//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(provinceId);//省
            bigdataFenxiCount.setProvinceName(provinceName);
            bigdataFenxiCount.setCityId(cityId);//市
            bigdataFenxiCount.setCityName(cityName);
            bigdataFenxiCount.setXianquId(xianQuId);//县区
            bigdataFenxiCount.setXianquName(xianQuName);
            bigdataFenxiCount.setCountType("XIANQU");//区域统计类型
            bigdataFenxiCount.setTimeType("DAY");//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setAlarmCarNum(0);//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(0);//报警企业数
        }else {
            //行驶时长
            BigDecimal shiChang = (BigDecimal) map.get("runTimeLength");
            //行驶里程
            BigDecimal liCheng = (BigDecimal) map.get("runMileage");
            BigDecimal changGuiBaoJing = (BigDecimal) map.get("commonAlarmNum");//常规报警数量
            BigDecimal changGuiChuLi = (BigDecimal) map.get("commonHandleNum");//常规处理数量
            BigDecimal zhuDongAnQuanBaoJing = (BigDecimal) map.get("safeAlarmNum");//主动安全报警数量
            BigDecimal zhuDongAnQuanChuLi = (BigDecimal) map.get("safeHandleNum");//主动安全处理数量
            bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing.intValue());
            bigdataFenxiCount.setCommonHandleNum(changGuiChuLi.intValue());
            bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi.intValue());
            bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing.intValue());
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(shiChang.divide(new BigDecimal(60),2, RoundingMode.HALF_UP));//时长
            bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(provinceId);//省
            bigdataFenxiCount.setProvinceName(provinceName);
            bigdataFenxiCount.setCityId(cityId);//市
            bigdataFenxiCount.setCityName(cityName);
            bigdataFenxiCount.setXianquId(xianQuId);//县区
            bigdataFenxiCount.setXianquName(xianQuName);
            bigdataFenxiCount.setCountType("XIANQU");//区域统计类型
            bigdataFenxiCount.setTimeType("DAY");//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setAlarmCarNum(bigdataTimeCarDayRecMapper.selectAlarmNumXianQu(xianQuId,countDay,countMonth,yearNum,carType));//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(bigdataTimeCarDayRecMapper.selectCompNumXianQu(xianQuId,countDay,countMonth,yearNum,carType));//报警企业数
        }
        int flag = bigdataFenxiCountMapper.selectByInfoDay(xianQuId,carType,countDay,countMonth,yearNum,"XIANQU","DAY");
        if(flag!=0){
            bigdataFenxiCount.setUpdateTime(new Date());
            bigdataFenxiCountMapper.updateByInfo(bigdataFenxiCount);
        }else {
            bigdataFenxiCountMapper.insert(bigdataFenxiCount);
        }
    }

    public Map<String,List<BigdataTimeCarDayRec>> getMap(List<BigdataTimeCarDayRec> list){
        //同一个县区
        List<BigdataTimeCarDayRec> listPuHuo = new ArrayList<>();//普货
        List<BigdataTimeCarDayRec> listKeYun = new ArrayList<>();//客运
        List<BigdataTimeCarDayRec> listWeiHuo = new ArrayList<>();//危货
        for(BigdataTimeCarDayRec bigdataTimeCarDayRec : list){
            if(bigdataTimeCarDayRec.getCarType()!=null && bigdataTimeCarDayRec.getCarType().equals("普货")){
                listPuHuo.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getCarType()!=null && bigdataTimeCarDayRec.getCarType().equals("客运")){
                listKeYun.add(bigdataTimeCarDayRec);
            }else if(bigdataTimeCarDayRec.getCarType()!=null && bigdataTimeCarDayRec.getCarType().equals("危货")){
                listWeiHuo.add(bigdataTimeCarDayRec);
            }
        }
        Map<String,List<BigdataTimeCarDayRec>> map = new HashMap<>();
        map.put("listPuHuo",listPuHuo);
        map.put("listKeYun",listKeYun);
        map.put("listWeiHuo",listWeiHuo);
        return map;
    }

    //统计第几周
    public Integer getWeek(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    //0 0 17 L * ?(每个月的最后一天 下午5点执行，月统计)
    @Scheduled(cron = "0 20 2 * * ?")//0/2 * * * * ? 0 20 2 * * ?
    public void monthCountInfo(){
        //每个月的最后一天 开始统计
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        //根据统计月份  年份 分别县区和市
        List<BigdataFenxiCount> listHGQ = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","海港区");
        insertInfoMonth(listHGQ,"总","XIANQU");
        List<BigdataFenxiCount> listSHG = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","山海关区");
        insertInfoMonth(listSHG,"总","XIANQU");
        List<BigdataFenxiCount> listBDH = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","北戴河区");
        insertInfoMonth(listBDH,"总","XIANQU");
        List<BigdataFenxiCount> listCL = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","昌黎县");
        insertInfoMonth(listCL,"总","XIANQU");
        List<BigdataFenxiCount> listQL = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","青龙县");
        insertInfoMonth(listQL,"总","XIANQU");
        List<BigdataFenxiCount> listKFQ = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","开发区");
        insertInfoMonth(listKFQ,"总","XIANQU");
        List<BigdataFenxiCount> listFN = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","抚宁区");
        insertInfoMonth(listFN,"总","XIANQU");
        List<BigdataFenxiCount> listLL = bigdataFenxiCountMapper.selectXianQuAndMonth("DAY",yearNum,countMonth,"XIANQU","卢龙县");
        insertInfoMonth(listLL,"总","XIANQU");
        List<BigdataFenxiCount> listAll = bigdataFenxiCountMapper.selectCityAndMonth("DAY",yearNum,countMonth,"CITY");
        insertInfoMonth(listAll,"总","CITY");

        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","海港区")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","山海关区")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","北戴河区")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","昌黎县")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","青龙县")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","开发区")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","抚宁区")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndMonthAll("DAY",yearNum,countMonth,"XIANQU","卢龙县")),"XIANQU");
        carTypeDataMonthInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectCityAndMonthAll("DAY",yearNum,countMonth,"CITY")),"CITY");

    }

    private void carTypeDataMonthInsert(Map<String, List<BigdataFenxiCount>> map,String countType) {
        for(Map.Entry<String, List<BigdataFenxiCount>> entry : map.entrySet()){
            String mapKey = entry.getKey();
            List<BigdataFenxiCount> valueList = entry.getValue();
            if(mapKey.equals("listPuHuo")){//普货
                insertInfoMonth(valueList,"普货",countType);
            }else if(mapKey.equals("listKeYun")){//客运
                insertInfoMonth(valueList,"客运",countType);
            }else if(mapKey.equals("listWeiHuo")){//危货
                insertInfoMonth(valueList,"危货",countType);
            }
        }
    }

    public void insertInfoMonth(List<BigdataFenxiCount> list,String carType,String countType){
        //设置日期
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        if(countType.equals("CITY")){
            BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
            //行驶时长
            BigDecimal shiChang = new BigDecimal(0);
            //行驶里程
            BigDecimal liCheng = new BigDecimal(0);
            Integer changGuiBaoJing = new Integer(0);//常规报警数量
            Integer changGuiChuLi = new Integer(0);//常规处理数量
            Integer zhuDongAnQuanBaoJing = new Integer(0);//主动安全报警数量
            Integer zhuDongAnQuanChuLi = new Integer(0);//主动安全处理数量
            Integer alarmNum = new Integer(0);//报警车辆数
            Integer compNum = new Integer(0);//报警企业数
            for(BigdataFenxiCount bigdataFenxiCount1 : list){
                alarmNum = alarmNum + bigdataFenxiCount1.getAlarmCarNum();//报警车辆数
                compNum = compNum + bigdataFenxiCount1.getAlarmCompNum();//报警企业数
                changGuiBaoJing = changGuiBaoJing + bigdataFenxiCount1.getCommonAlarmNum();//常规报警数量
                changGuiChuLi = changGuiChuLi+bigdataFenxiCount1.getCommonHandleNum();//常规处理数量
                zhuDongAnQuanBaoJing = zhuDongAnQuanBaoJing + bigdataFenxiCount1.getSafeAlarmNum();//主动安全报警数量
                zhuDongAnQuanChuLi = zhuDongAnQuanChuLi + bigdataFenxiCount1.getSafeHandleNum();//主动安全处理数量
                shiChang = shiChang.add(bigdataFenxiCount1.getRunTimeLengthHour());
                liCheng = liCheng.add(bigdataFenxiCount1.getRunMileage());
            }
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(shiChang);//时长
            bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(list.get(0).getProvinceId());//省
            bigdataFenxiCount.setProvinceName(list.get(0).getProvinceName());
            bigdataFenxiCount.setCityId(list.get(0).getCityId());//市
            bigdataFenxiCount.setCityName(list.get(0).getCityName());
            bigdataFenxiCount.setCountType(countType);//区域统计类型
            bigdataFenxiCount.setTimeType("MONTH");//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setAlarmCarNum(alarmNum);//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(compNum);//报警企业数
            bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing);
            bigdataFenxiCount.setCommonHandleNum(changGuiChuLi);
            bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing);
            bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi);
            int flag = bigdataFenxiCountMapper.selectByInfo("",carType,countDay,countMonth,yearNum,countType,"MONTH");
            if(flag!=0){
                bigdataFenxiCount.setUpdateTime(new Date());
                bigdataFenxiCountMapper.updateByInfoMonth(bigdataFenxiCount);
            }else {
                bigdataFenxiCountMapper.insert(bigdataFenxiCount);
            }
        }else {
            BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
            //行驶时长
            BigDecimal shiChang = new BigDecimal(0);
            //行驶里程
            BigDecimal liCheng = new BigDecimal(0);
            Integer changGuiBaoJing = new Integer(0);//常规报警数量
            Integer changGuiChuLi = new Integer(0);//常规处理数量
            Integer zhuDongAnQuanBaoJing = new Integer(0);//主动安全报警数量
            Integer zhuDongAnQuanChuLi = new Integer(0);//主动安全处理数量
            Integer alarmNum = new Integer(0);//报警车辆数
            Integer compNum = new Integer(0);//报警企业数
            for(BigdataFenxiCount bigdataFenxiCount1 : list){
                alarmNum = alarmNum + bigdataFenxiCount1.getAlarmCarNum();//报警车辆数
                compNum = compNum + bigdataFenxiCount1.getAlarmCompNum();//报警企业数
                changGuiBaoJing = changGuiBaoJing + bigdataFenxiCount1.getCommonAlarmNum();//常规报警数量
                changGuiChuLi = changGuiChuLi+bigdataFenxiCount1.getCommonHandleNum();//常规处理数量
                zhuDongAnQuanBaoJing = zhuDongAnQuanBaoJing + bigdataFenxiCount1.getSafeAlarmNum();//主动安全报警数量
                zhuDongAnQuanChuLi = zhuDongAnQuanChuLi + bigdataFenxiCount1.getSafeHandleNum();//主动安全处理数量
                shiChang = shiChang.add(bigdataFenxiCount1.getRunTimeLengthHour());
                liCheng = liCheng.add(bigdataFenxiCount1.getRunMileage());
            }
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(shiChang);//时长
            bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(list.get(0).getProvinceId());//省
            bigdataFenxiCount.setProvinceName(list.get(0).getProvinceName());
            bigdataFenxiCount.setCityId(list.get(0).getCityId());//市
            bigdataFenxiCount.setCityName(list.get(0).getCityName());
            bigdataFenxiCount.setXianquId(list.get(0).getXianquId());//县区
            bigdataFenxiCount.setXianquName(list.get(0).getXianquName());
            bigdataFenxiCount.setCountType(countType);//区域统计类型
            bigdataFenxiCount.setTimeType("MONTH");//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setAlarmCarNum(alarmNum);//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(compNum);//报警企业数
            bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing);
            bigdataFenxiCount.setCommonHandleNum(changGuiChuLi);
            bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing);
            bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi);
            int flag = bigdataFenxiCountMapper.selectByInfo(list.get(0).getXianquId(),carType,countDay,countMonth,yearNum,countType,"MONTH");
            if(flag!=0){
                bigdataFenxiCount.setUpdateTime(new Date());
                bigdataFenxiCountMapper.updateByInfoMonth(bigdataFenxiCount);
            }else {
                bigdataFenxiCountMapper.insert(bigdataFenxiCount);
            }
        }
    }


    //获取某一年的某一周的周日日期
    public Integer getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(cal.getTime());
        return new Integer(dateStr);
    }

    //获取某一年的某一周的周一日期
    public Integer getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(cal.getTime());
        return new Integer(dateStr);

    }

    //0 0 17 ? 1-12 1(每个周的周日统计 下午5点执行，周统计)0/2 * * * * ? 0 0 2 * * ?
    @Scheduled(cron = "0 0 2 * * ?")
    public void weekCountInfo(){
        //计算当前时间为第几周
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        Integer week = getWeek(dateStr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        //根据周数查询 分别是县区和市  分别32 4 36*7
        //一个县区 一天 4个记录 七天 28个记录 根据周加上XIANQU查出所有
        //返回七天的集合
        Integer startTime = getStartDayOfWeekNo(yearNum,week);
        Integer endTime = getEndDayOfWeekNo(yearNum,week);
        //可以将所有总数计算
        List<BigdataFenxiCount> listHGQ = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","海港区");
        insertInfo(listHGQ,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listSHG = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","山海关区");
        insertInfo(listSHG,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listBDH = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","北戴河区");
        insertInfo(listBDH,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listCL = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","昌黎县");
        insertInfo(listCL,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listQL = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","青龙县");
        insertInfo(listQL,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listKFQ = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","开发区");
        insertInfo(listKFQ,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listFN = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","抚宁区");
        insertInfo(listFN,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listLL = bigdataFenxiCountMapper.selectXianQuAndTimeAll("DAY",startTime,endTime,"XIANQU","卢龙县");
        insertInfo(listLL,"总","XIANQU","WEEK",week);
        List<BigdataFenxiCount> listAll = bigdataFenxiCountMapper.selectCityAndTimeAll("DAY",startTime,endTime,"CITY");
        insertInfo(listAll,"总","CITY","WEEK",week);
        //后将总的切分三个车辆类型
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","海港区")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","山海关区")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","北戴河区")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","昌黎县")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","青龙县")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","开发区")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","抚宁区")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectXianQuAndTime("DAY",startTime,endTime,"XIANQU","卢龙县")),
                        "XIANQU",week);
        carTypeDataInsert(getMapFenXiCount(bigdataFenxiCountMapper.selectCityAndTime("DAY",startTime,endTime,"CITY")),"CITY",week);
    }

    private void carTypeDataInsert(Map<String, List<BigdataFenxiCount>> map,String countType,Integer week) {
        for(Map.Entry<String, List<BigdataFenxiCount>> entry : map.entrySet()){
            String mapKey = entry.getKey();
            List<BigdataFenxiCount> valueList = entry.getValue();
            if(mapKey.equals("listPuHuo")){//普货
                insertInfo(valueList,"普货",countType,"WEEK",week);
            }else if(mapKey.equals("listKeYun")){//客运
                insertInfo(valueList,"客运",countType,"WEEK",week);
            }else if(mapKey.equals("listWeiHuo")){//危货
                insertInfo(valueList,"危货",countType,"WEEK",week);
            }
        }
    }

    //总的切分三个车辆类型
    public Map<String,List<BigdataFenxiCount>> getMapFenXiCount(List<BigdataFenxiCount> list){
        //同一个县区
        List<BigdataFenxiCount> listPuHuo = new ArrayList<>();//普货
        List<BigdataFenxiCount> listKeYun = new ArrayList<>();//客运
        List<BigdataFenxiCount> listWeiHuo = new ArrayList<>();//危货
        for(BigdataFenxiCount bigdataFenxiCount : list){
            if(bigdataFenxiCount.getCarType()!=null && bigdataFenxiCount.getCarType().equals("普货")){
                listPuHuo.add(bigdataFenxiCount);
            }else if(bigdataFenxiCount.getCarType()!=null && bigdataFenxiCount.getCarType().equals("客运")){
                listKeYun.add(bigdataFenxiCount);
            }else if(bigdataFenxiCount.getCarType()!=null && bigdataFenxiCount.getCarType().equals("危货")){
                listWeiHuo.add(bigdataFenxiCount);
            }
        }
        Map<String,List<BigdataFenxiCount>> map = new HashMap<>();
        map.put("listPuHuo",listPuHuo);
        map.put("listKeYun",listKeYun);
        map.put("listWeiHuo",listWeiHuo);
        return map;
    }



    public void insertInfo(List<BigdataFenxiCount> list,String carType,String countType,String timeType,Integer week){
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        if(countType.equals("CITY")){
            BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
            //行驶时长
            BigDecimal shiChang = new BigDecimal(0);
            //行驶里程
            BigDecimal liCheng = new BigDecimal(0);
            Integer changGuiBaoJing = new Integer(0);//常规报警数量
            Integer changGuiChuLi = new Integer(0);//常规处理数量
            Integer zhuDongAnQuanBaoJing = new Integer(0);//主动安全报警数量
            Integer zhuDongAnQuanChuLi = new Integer(0);//主动安全处理数量
            Integer alarmNum = new Integer(0);//报警车辆数
            Integer compNum = new Integer(0);//报警企业数
            for(BigdataFenxiCount bigdataFenxiCount1 : list){
                alarmNum = alarmNum + bigdataFenxiCount1.getAlarmCarNum();//报警车辆数
                compNum = compNum + bigdataFenxiCount1.getAlarmCompNum();//报警企业数
                changGuiBaoJing = changGuiBaoJing + bigdataFenxiCount1.getCommonAlarmNum();//常规报警数量
                changGuiChuLi = changGuiChuLi+bigdataFenxiCount1.getCommonHandleNum();//常规处理数量
                zhuDongAnQuanBaoJing = zhuDongAnQuanBaoJing + bigdataFenxiCount1.getSafeAlarmNum();//主动安全报警数量
                zhuDongAnQuanChuLi = zhuDongAnQuanChuLi + bigdataFenxiCount1.getSafeHandleNum();//主动安全处理数量
                shiChang = shiChang.add(bigdataFenxiCount1.getRunTimeLengthHour());
                liCheng = liCheng.add(bigdataFenxiCount1.getRunMileage());
            }
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(shiChang);//时长
            bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(list.get(0).getProvinceId());//省
            bigdataFenxiCount.setProvinceName(list.get(0).getProvinceName());
            bigdataFenxiCount.setCityId(list.get(0).getCityId());//市
            bigdataFenxiCount.setCityName(list.get(0).getCityName());
            bigdataFenxiCount.setCountType(countType);//区域统计类型
            bigdataFenxiCount.setTimeType(timeType);//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setCountWeek(week);
            bigdataFenxiCount.setAlarmCarNum(alarmNum);//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(compNum);//报警企业数
            bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing);
            bigdataFenxiCount.setCommonHandleNum(changGuiChuLi);
            bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing);
            bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi);
            int flag = bigdataFenxiCountMapper.selectByInfoWeek("",carType,countDay,countMonth,yearNum,countType,timeType,week);
            if(flag!=0){
                bigdataFenxiCount.setUpdateTime(new Date());
                bigdataFenxiCountMapper.updateByInfoWeek(bigdataFenxiCount);
            }else {
                bigdataFenxiCountMapper.insert(bigdataFenxiCount);
            }
        }else {
            BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
            //行驶时长
            BigDecimal shiChang = new BigDecimal(0);
            //行驶里程
            BigDecimal liCheng = new BigDecimal(0);
            Integer changGuiBaoJing = new Integer(0);//常规报警数量
            Integer changGuiChuLi = new Integer(0);//常规处理数量
            Integer zhuDongAnQuanBaoJing = new Integer(0);//主动安全报警数量
            Integer zhuDongAnQuanChuLi = new Integer(0);//主动安全处理数量
            Integer alarmNum = new Integer(0);//报警车辆数
            Integer compNum = new Integer(0);//报警企业数
            for(BigdataFenxiCount bigdataFenxiCount1 : list){
                alarmNum = alarmNum + bigdataFenxiCount1.getAlarmCarNum();//报警车辆数
                compNum = compNum + bigdataFenxiCount1.getAlarmCompNum();//报警企业数
                changGuiBaoJing = changGuiBaoJing + bigdataFenxiCount1.getCommonAlarmNum();//常规报警数量
                changGuiChuLi = changGuiChuLi+bigdataFenxiCount1.getCommonHandleNum();//常规处理数量
                zhuDongAnQuanBaoJing = zhuDongAnQuanBaoJing + bigdataFenxiCount1.getSafeAlarmNum();//主动安全报警数量
                zhuDongAnQuanChuLi = zhuDongAnQuanChuLi + bigdataFenxiCount1.getSafeHandleNum();//主动安全处理数量
                shiChang = shiChang.add(bigdataFenxiCount1.getRunTimeLengthHour());
                liCheng = liCheng.add(bigdataFenxiCount1.getRunMileage());
            }
            bigdataFenxiCount.setId(Guid.guid());//主键
            bigdataFenxiCount.setRunTimeLengthHour(shiChang);//时长
            bigdataFenxiCount.setRunMileage(liCheng);//行驶里程
            bigdataFenxiCount.setCreateTime(new Date());//创建时间
            bigdataFenxiCount.setProvinceId(list.get(0).getProvinceId());//省
            bigdataFenxiCount.setProvinceName(list.get(0).getProvinceName());
            bigdataFenxiCount.setCityId(list.get(0).getCityId());//市
            bigdataFenxiCount.setCityName(list.get(0).getCityName());
            bigdataFenxiCount.setXianquId(list.get(0).getXianquId());//县区
            bigdataFenxiCount.setXianquName(list.get(0).getXianquName());
            bigdataFenxiCount.setCountType(countType);//区域统计类型
            bigdataFenxiCount.setTimeType(timeType);//时间类型
            bigdataFenxiCount.setCarType(carType);//车辆类型
            bigdataFenxiCount.setCountDate(countDay);//日
            bigdataFenxiCount.setCountMonth(countMonth);//月
            bigdataFenxiCount.setYearNum(yearNum);//年
            bigdataFenxiCount.setCountWeek(week);
            bigdataFenxiCount.setAlarmCarNum(alarmNum);//报警车辆数
            bigdataFenxiCount.setAlarmCompNum(compNum);//报警企业数
            bigdataFenxiCount.setCommonAlarmNum(changGuiBaoJing);
            bigdataFenxiCount.setCommonHandleNum(changGuiChuLi);
            bigdataFenxiCount.setSafeAlarmNum(zhuDongAnQuanBaoJing);
            bigdataFenxiCount.setSafeHandleNum(zhuDongAnQuanChuLi);
            int flag = bigdataFenxiCountMapper.selectByInfoWeek(list.get(0).getXianquId(),carType,countDay,countMonth,yearNum,countType,timeType,week);
            if(flag!=0){
                bigdataFenxiCount.setUpdateTime(new Date());
                bigdataFenxiCountMapper.updateByInfoWeek(bigdataFenxiCount);
            }else {
                bigdataFenxiCountMapper.insert(bigdataFenxiCount);
            }
        }
    }
}
