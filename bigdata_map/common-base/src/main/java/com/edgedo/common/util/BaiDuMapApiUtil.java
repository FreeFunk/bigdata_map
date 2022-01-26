package com.edgedo.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class BaiDuMapApiUtil {

    String geocoderAk = "zQTyHWw2m3T2pGVUylSprh13n5680CYf";

    public BaiDuMapApiUtil(String geocoderAk) {
        this.geocoderAk = geocoderAk;
    }

    public BaiDuMapApiUtil() {

    }

    private static final String BAIDU_Geocoder_URL = "http://api.map.baidu.com/geocoder/v2/?location=经纬度&output=json&pois=0&latest_admin=1&ak=反查秘钥";

    /**
     * 位置查询
     * @param latLong
     */
    public MapPointInfo latLongSearch(String latLong) throws IOException {
        return latLongSearch(latLong,geocoderAk);
    }

    public static MapPointInfo latLongSearch(String latLong,String ak) throws IOException {
        String url = BAIDU_Geocoder_URL.replaceAll("经纬度",latLong);
        url = url.replaceAll("反查秘钥",ak);
        String res = HttpRequestUtil.sendGetRequest(url);
        JSONObject obj = JSONObject.parseObject(res);
        String status = obj.get("status")+"";
//        System.out.println("未查到位置:"  + res);
        if(status!=null && status.equals("0")){
            JSONObject resultObj = (JSONObject)obj.get("result");
            JSONObject addressComponentObj = (JSONObject)resultObj.get("addressComponent");
            String formatted_address = resultObj.get("formatted_address")+"";
            String country = addressComponentObj.get("country") + "";
            String province = addressComponentObj.get("province") + "";
            String city = addressComponentObj.get("city") + "";
            String district = addressComponentObj.get("district")+"";
            String sematic_description = resultObj.get("sematic_description") + "";
            MapPointInfo pointInfo = new MapPointInfo();
            pointInfo.setFormatted_address(formatted_address);
            pointInfo.setCountry(country);
            pointInfo.setProvince(province);
            pointInfo.setCity(city);
            pointInfo.setDistrict(district);
            pointInfo.setSematic_description(sematic_description);
            return pointInfo;
        }

        return null;

    }

    //根据经纬度查道路位置
    public static String roadSearch(String lat,String ln){
        String url = "http://g.gpsoo.net/o.jsp?i="+ln+","+lat+",0&map=baidu";
        try {
            String res = HttpRequestUtil.sendGetRequest(url);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getGeocoderAk() {
        return geocoderAk;
    }

    public void setGeocoderAk(String geocoderAk) {
        this.geocoderAk = geocoderAk;
    }


  /*  public static void main(String[] args) throws IOException {
        BaiDuMapApiUtil apiUtil = new BaiDuMapApiUtil();
        String res = roadSearch("39.793729","118.686316");
        System.out.println(res);
    }*/
    //百度地图点描述


    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

  /*  public static void main(String[] args){
        System.out.println(getDistance(39.712338,119.060098,39.712400,119.060085));
    }*/

}

