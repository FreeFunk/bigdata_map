package com.edgedo.timetask.analysis;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.TransitCarInfoQuery;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.Guid;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import com.edgedo.common.util.RedisUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataUpdateCarInfo.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataUpdateCarInfo {

    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataCarRealtimeGpsService bigdataCarRealtimeGpsService;
    @Autowired
    BigdataBeidouTeamInfoService bigdataBeidouTeamInfoService;
    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    BigdataZhygService zhygService;

    @Value("${bigdata.carPlatePrefix}")
    private String carPlatePrefix;
    @Value("${ReportDataUrl}")
    private String ReportDataUrl;

    //@Scheduled(cron = "0 44 22 * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataUpdateCarInfo.cron.updateCarInfo}")
    public void  updateCarInfo(){
        int totalCarNum = carInfoService.selectSortNum();
        final int oneNum = 1000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        //????????????????????????
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1)-1;
                    List<CarInfo> carList = carInfoService.listByStartAndEndBySortNum(start,end);
                    for(CarInfo car : carList){
                        String carPlateNum = car.getCarPlateNum();
                        String carPlateColour = car.getCarPlateColour();
                        TransitCarBaseinfo carBaseinfo = zhygService.selectCarWithEmpInfoByCarPlateAndColor(carPlateNum, getColor(carPlateColour));
                        if (carBaseinfo != null) {
                            updateTransitCarBaseInfo(carBaseinfo,carPlateNum+"_"+carPlateColour);
                        }
                    }
                }
            };
            t.start();
        }
    }


    //@Scheduled(cron = "0 28 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataUpdateCarInfo.cron.tongBuCarInfoByGps1}")
    public void tongBuCarInfoByGps1(){
        //1.???????????????gps??????????????????
        List<BigdataCarRealtimeGpsView>  notExistCarList = bigdataCarRealtimeGpsService.selectGpsCarNotInCarInfo();
        int count = 0;
        //2.????????????????????????????????????????????????
        for(BigdataCarRealtimeGpsView gpsCar : notExistCarList){
            try {
                BigdataBeidouCompView beidouComp =  bigdataBeidouCompService.selectByIp809Addr(gpsCar.getIp());
                String carPlateNum = gpsCar.getCarPlateNum();
                String carPlateColor = gpsCar.getCarPlateColor();
                //3.????????????????????????carinfo
                TransitCarBaseinfo carBaseinfo = zhygService.selectCarWithEmpInfoByCarPlateAndColor(carPlateNum, getColor(carPlateColor));
                if (carBaseinfo != null) {
                    count++;
                    insertOrUpdate(carBaseinfo, carPlateNum + "_" + carPlateColor,beidouComp);
                    gpsCar.setCarInfoSynState("?????????");
                }else{
                    gpsCar.setCarInfoSynState("?????????????????????");
                }
                bigdataCarRealtimeGpsService.update(gpsCar);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        System.out.println("?????? : " + count);


    }


    //??????????????????????????????
    //@Scheduled(cron = "0 55 22 * * ?")
    public void tongBuCarInfoExt(){
        try {
            //??????
            TransitCarTeamQuery query = new TransitCarTeamQuery();
            query.setCityId("130300");
            query.setCompanyLavel("TEAM_KY");
            tongBuKyCarInfo(query);
            //??????
            TransitCarTeamQuery query2 = new TransitCarTeamQuery();
            query2.setCityId("130300");
            query2.setCompanyLavel("TEAM_WXHWYS");
            tongBuKyCarInfo(query2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //??????????????????????????????
    public void tongBuKyCarInfo(TransitCarTeamQuery query){
        try {
            String reportDataTeamUrl = ReportDataUrl+"/sys/carTeam/selectTeamCarInfo.jsn";
            String companyLavel = query.getCompanyLavel();
            Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
            String responseStr = HttpRequestUtil.sendPostRequest(reportDataTeamUrl,parameterMap);
            org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr);
            JSONArray jsonArray = jsonObject.optJSONArray("list");
            List<TransitCarTeam> transitCarTeamList = com.alibaba.fastjson.JSONArray.parseArray(jsonArray.toString(), TransitCarTeam.class);
            String reportDataCarUrl =ReportDataUrl + "/sys/transitCarBaseinfo/selectCarByCarTeam.jsn";
            TransitCarInfoQuery transitCarInfoQuery = new TransitCarInfoQuery();
            for(TransitCarTeam team:transitCarTeamList){
                transitCarInfoQuery.setOwnerTeamId(team.getId());
                transitCarInfoQuery.setCityId("130300");
                Map<String,String> parameterMap1 = ObjectUtil.objectToMapString(transitCarInfoQuery,"");
                String responseStr1 = HttpRequestUtil.sendPostRequest(reportDataCarUrl,parameterMap1);
                org.json.JSONObject jsonObject1 = new org.json.JSONObject(responseStr1);
                JSONArray jsonArray1 = jsonObject1.optJSONArray("data");
                List<TransitCarBaseinfo> transitCarBaseinfoList = com.alibaba.fastjson.JSONArray.parseArray(jsonArray1.toString(), TransitCarBaseinfo.class);
                for(TransitCarBaseinfo car:transitCarBaseinfoList){
                    String carPlateNum = car.getCarPlateNum();
                    if(carPlateNum.contains("???")){
                        continue;
                    }
                    CarInfo carInfo = new CarInfo();
                    carInfo.setCreateTime(new Date());
                    carInfo.setCarPlateNum(car.getCarPlateNum());
                    carInfo.setCarFrameNum(car.getCarFrameNum());
                    carInfo.setCarPlateColour(getColor1(car.getCarPlateColor()));
                    carInfo.setCarPlateColorText(genCarPlateColorTextFromCode(carInfo.getCarPlateColour()));
                    carInfo.setProvinceId(car.getProvinceId());
                    carInfo.setProvinceName(car.getProvinceName());
                    carInfo.setCityId(car.getCityId());
                    carInfo.setCityName(car.getCityName());
                    carInfo.setXianquId(car.getXianquId());
                    carInfo.setXianquName(car.getXianquName());
                    carInfo.setLicenseCode(car.getJyCertNumber());
                    carInfo.setOwnerName(car.getContactPerson());
                    carInfo.setOwnerPhoneNum(car.getContactPhone());
                    if(companyLavel.equals("TEAM_KY")){
                        carInfo.setCarType("??????");
                    }
                    if(companyLavel.equals("TEAM_WXHWYS")){
                        carInfo.setCarType("??????");
                    }
                    carInfo.setCarTransitType(car.getYingyunType());
                    carInfo.setCarBrand(car.getCarBrandsName());
                    carInfo.setOutsizeLength(new BigDecimal(car.getOutsizeLength()));
                    carInfo.setOutsizeWidth(new BigDecimal(car.getOutsizeWidth()));
                    carInfo.setOutsizeHeight(new BigDecimal(car.getOutsizeHeight()));
                    carInfo.setOwnerTeamId(car.getOwnerCarTeamId());
                    carInfo.setOwnerTeamName(car.getOwnerCarTeamName());
                    carInfoService.insertOrUpdate(carInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertOrUpdate(TransitCarBaseinfo t,String carInfoId,BigdataBeidouCompView beidouComp){
        CarInfo carInfo1 = new CarInfo();
        if(beidouComp!=null){
            carInfo1.setComId(beidouComp.getId());
            carInfo1.setComName(beidouComp.getCompName());
        }
        carInfo1.setDataState(t.getDataState());
        carInfo1.setCreateTime(new Date());
        carInfo1.setProvinceId(t.getProvinceId());
        carInfo1.setProvinceName(t.getProvinceName());
        carInfo1.setCityId(t.getCityId());
        carInfo1.setCityName(t.getCityName());
        carInfo1.setXianquId(t.getXianquId());
        carInfo1.setXianquName(t.getXianquName());
        carInfo1.setCarPlateNum(t.getCarPlateNum());
        carInfo1.setCarPlateColour(getColor1(t.getCarPlateColor()));
        carInfo1.setCarPlateColorText(genCarPlateColorTextFromCode(carInfo1.getCarPlateColour()));
        String totalTakeMass = t.getTotalTakeMass();
        if(!isNumeric(totalTakeMass)){
            totalTakeMass = "0";
        }
        if( Double.valueOf(totalTakeMass).intValue()>40000){
            totalTakeMass = "40000";
        }
        String totalPullMass = t.getTotalPullMass();
        if(!isNumeric(totalPullMass)){
            totalPullMass = "0";
        }
        if(Double.valueOf(totalPullMass)>40000){
            totalPullMass = "40000";
        }
        String sitPeopleNum = t.getSitPeopleNum();
        if(!isNumeric(sitPeopleNum)){
            sitPeopleNum = "0";
        }
        carInfo1.setTotalTakeMass(new BigDecimal(totalTakeMass));
        carInfo1.setTotalPullMass(new BigDecimal(totalPullMass));
        carInfo1.setSitPeopleNum(new BigDecimal(sitPeopleNum).intValue());
        carInfo1.setCarFrameNum(t.getCarFrameNum());
        carInfo1.setLicenseCode(t.getJyCertNumber());
        carInfo1.setOwnerName(t.getContactPerson());
        carInfo1.setOwnerPhoneNum(t.getContactPhone());
        carInfo1.setCarTransitType(t.getYingyunType());
        carInfo1.setCarBrand(t.getCarBrandsName());
        carInfo1.setCarModel(t.getCarProductCode());
        carInfo1.setOutsizeLength(new BigDecimal(t.getOutsizeLength()));
        carInfo1.setOutsizeWidth(new BigDecimal(t.getOutsizeWidth()));
        carInfo1.setOutsizeHeight(new BigDecimal(t.getOutsizeHeight()));
        carInfo1.setOwnerTeamId(t.getOwnerCarTeamId());
        carInfo1.setOwnerTeamName(t.getOwnerCarTeamName());
        carInfo1.setId(carInfoId);
        carInfo1.setEmpId(t.getEmpId());
        carInfo1.setEmpName(t.getEmpName());
        carInfo1.setEmpCode(t.getEmpCode());
        carInfo1.setEmpPhone(t.getEmpPhone());
        TransitCarTeam team = zhygService.selectTeamInfoById(t.getOwnerCarTeamId());
        if(team != null) {
            String companyLevel = team.getCompanyLevel();
            carInfo1.setCarType(getCarType(companyLevel));
            if (companyLevel != null && (companyLevel.equals("TEAM_KY") || companyLevel.equals("TEAM_WXHWYS"))) {
                //????????????????????????
                BigdataBeidouTeamInfo bigdataBeidouTeamInfo = new BigdataBeidouTeamInfo();
                bigdataBeidouTeamInfo.setProvinceId(team.getProvinceId());
                bigdataBeidouTeamInfo.setProvinceName(team.getProvinceName());
                bigdataBeidouTeamInfo.setCityId(team.getCityId());
                bigdataBeidouTeamInfo.setCityName(team.getCityName());
                bigdataBeidouTeamInfo.setXianquId(team.getXianquId());
                bigdataBeidouTeamInfo.setXianquName(team.getXianquName());
                bigdataBeidouTeamInfo.setTeamType(companyLevel);
                bigdataBeidouTeamInfo.setId(team.getId());
                bigdataBeidouTeamInfo.setTeamName(team.getTeamName());
                bigdataBeidouTeamInfo.setDataState(team.getDataState());
                bigdataBeidouTeamInfoService.insertOrUpdate(bigdataBeidouTeamInfo);
            }
        }
        String carType = carInfo1.getCarType();
        if(carType==null || carType.equals("")){
            carInfo1.setCarType(getCarTypeByTransitType(carInfo1.getCarTransitType()));
        }
        carInfoService.insertOrUpdate(carInfo1);
    }

    public void updateTransitCarBaseInfo(TransitCarBaseinfo t,String carInfoId){
        CarInfo carInfo = new CarInfo();
        carInfo.setDataState(t.getDataState());
        carInfo.setProvinceId(t.getProvinceId());
        carInfo.setProvinceName(t.getProvinceName());
        carInfo.setCityId(t.getCityId());
        carInfo.setCityName(t.getCityName());
        carInfo.setXianquId(t.getXianquId());
        carInfo.setXianquName(t.getXianquName());
        carInfo.setCarFrameNum(t.getCarFrameNum());
        carInfo.setLicenseCode(t.getJyCertNumber());
        carInfo.setOwnerName(t.getContactPerson());
        carInfo.setOwnerPhoneNum(t.getContactPhone());
        carInfo.setCarTransitType(t.getYingyunType());
        carInfo.setCarBrand(t.getCarBrandsName());
        carInfo.setCarModel(t.getCarProductCode());
        carInfo.setOutsizeLength(new BigDecimal(t.getOutsizeLength()));
        carInfo.setOutsizeWidth(new BigDecimal(t.getOutsizeWidth()));
        carInfo.setOutsizeHeight(new BigDecimal(t.getOutsizeHeight()));
        carInfo.setOwnerTeamId(t.getOwnerCarTeamId());
        carInfo.setOwnerTeamName(t.getOwnerCarTeamName());
        carInfo.setId(carInfoId);
        carInfo.setEmpId(t.getEmpId());
        carInfo.setEmpName(t.getEmpName());
        carInfo.setEmpCode(t.getEmpCode());
        carInfo.setEmpPhone(t.getEmpPhone());
        carInfoService.update(carInfo);
    }

    /**
     * ????????????????????????????????????
     * 1:??????, 2:??????,	 3:??????,	 4:??????, 7:????????????	 9:??????
     * @param colorCode
     * @return
     */
    public static String genCarPlateColorTextFromCode(String colorCode){
        if(colorCode.indexOf("2")>=0){
            return "??????";
        }else if(colorCode.indexOf("1")>=0){
            return "??????";
        }else if(colorCode.indexOf("3")>=0){
            return "??????";
        }else if(colorCode.indexOf("4")>=0){
            return "??????";
        }else if(colorCode.indexOf("9")>=0){
            return "??????";
        }
        return "??????";
    }


    public String getColor(String color){
        if(color.equals("2")){
            return "2";
        }else if(color.equals("1")){
            return "3";
        }else {
            return "7";
        }
    }

    public String getColor1(String color){
        if(color.equals("2")){
            return "2";
        }else if(color.equals("3")){
            return "1";
        }else {
            return "9";
        }
    }
    //??????????????????
    public String getCarType(String companyLevel){
        if(companyLevel!=null){
            if(companyLevel.equals("TEAM_KY")){
                return "??????";
            }
            if(companyLevel.equals("TEAM_WXHWYS")){
                return "??????";
            }
        }
        return "??????";
    }
    //????????????????????????????????????
    public String getCarTypeByTransitType(String transitType){
        if(transitType!=null){
            if(transitType.contains("??????")){
                return "??????";
            }
            if(transitType.contains("??????")){
                return "??????";
            }
            return "??????";
        }
        return "??????";
    }
    //???????????????????????????????????????????????????????????????
    public  boolean isNumeric(String str) {
        if(str==null){
            return false;
        }
        Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");//???????????????
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public String trimCarPlateNum(String carPlateNum){
        carPlateNum = carPlateNum.replaceAll("[- _ #]","");
        int index = carPlateNum.indexOf(carPlatePrefix);
        if(index>0){
            carPlateNum = carPlateNum.replaceAll(" ","");
            carPlateNum = carPlateNum.substring(carPlateNum.indexOf(carPlatePrefix));
        }
        return carPlateNum;
    }


}
