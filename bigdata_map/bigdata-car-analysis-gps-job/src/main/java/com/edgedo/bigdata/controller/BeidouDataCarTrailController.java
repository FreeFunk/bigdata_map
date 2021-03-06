package com.edgedo.bigdata.controller;



import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataCarRealtimeSimple;
import com.edgedo.bigdata.entity.BigdataCarTrailGps;
import com.edgedo.bigdata.service.BigdataCarRealtimeGpsService;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.util.GpsLogFenxiUtil;
import freemarker.template.SimpleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/cartrail")
public class BeidouDataCarTrailController extends BaseController {

    @Value("${bigdata.dataHistoryGpsForder}")
    private String cartrailForder;
    @Value("${bigdata.dataRealTimeGpsFilePath}")
    private String dataRealTimeGpsFilePath;

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private GpsLogFenxiUtil gpsLogFenxiUtil;
    //格式化时分秒
    SimpleDateFormat sdfDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param carPlate
     * @param searchDay 20190516.log
     * @param response
     */
    @RequestMapping(value = "/loadCarTrail")
    public void loadCarTrail(
            String carPlate, String searchDay,
            HttpServletResponse response) {
        try {
            searchDay = searchDay.replaceAll("-", "");
            OutputStream os = response.getOutputStream();
//            String path = new String("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log".getBytes(), "GBK");
//            File file = new File("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log");
//            System.out.println(file.exists());
            File dataForder = new File(cartrailForder);
            File trailFile = new File(dataForder,
                    new String(carPlate.getBytes(), "GBK") +
                            File.separator +
                            searchDay + ".log");
            System.out.println("======" + trailFile.getAbsolutePath() + "|" + trailFile.exists());
            if (trailFile.exists()) {
                FileInputStream fis = null;
                BufferedReader br = null;
                try {
                    fis = new FileInputStream(trailFile);
                    byte[] buf = new byte[4096];
                    int length = 0;
                    while ((length = fis.read(buf)) > 0) {
                        os.write(buf, 0, length);
                    }
                    return;
                } catch (Exception e) {
                } finally {
                    if (fis != null) {
                        fis.close();
                    }
                }
            }
            os.write("".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 加载结构化的轨迹信息
     *
     * @param carPlate
     * @param searchTime 这个是查询轨迹点的开始时间
     */
    @RequestMapping(value = "/loadCarTrailWrap")
    public ModelAndView loadCarTrailWrap(
            String carPlate, String searchTime, String limitTime) {
        ModelAndView modelAndView = new ModelAndView();
        List<BigdataCarTrailGps> listSimple = new ArrayList<BigdataCarTrailGps>();
        String searchDay = searchTime.substring(0, 10);
        Long endTimeLong = null;
        try {
            Date startTime = sdfDatetime.parse(searchTime);
            if (limitTime != null && limitTime.length() > 0) {
                Date endTime = sdfDatetime.parse(limitTime);
                endTimeLong = endTime.getTime();
            }

            long startTimeLong = startTime.getTime();

            searchDay = searchDay.replaceAll("-", "");
//            String path = new String("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log".getBytes(), "GBK");
//            File file = new File("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log");
//            System.out.println(file.exists());
            File dataForder = new File(cartrailForder);
            File trailFile = new File(dataForder,
                    new String(carPlate.getBytes(), "GBK") +
                            File.separator +
                            searchDay + ".log");
            if (trailFile.exists()) {
                try {
                    InputStreamReader isr = null;
                    BufferedReader br = null;
                    try {
                        isr = new InputStreamReader(new FileInputStream(trailFile), "GBK");
                        br = new BufferedReader(isr);
                        String temLine = null;
                        while ((temLine = br.readLine()) != null) {
                            BigdataCarTrailGps realtimeGps = gpsLogFenxiUtil.fenxiOneCarTrail(temLine);
                            if (realtimeGps == null) {
                                continue;
                            }
                            long pointLong = realtimeGps.getLastPositionTime().getTime();
                            if (endTimeLong != null && pointLong > endTimeLong) {
                                break;
                            }
                            if (pointLong >= startTimeLong) {
                                listSimple.add(realtimeGps);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (br != null) {
                                br.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            if (isr != null) {
                                isr.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buildResponse(modelAndView, listSimple);
    }

    /**
     * 查询实时的定位信息
     */
    @RequestMapping(value = "/searchRealLocation")
    public Map<String, Object> loadCarTrail(String carPlateIds) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (carPlateIds == null || carPlateIds.length() == 0) {
            return result;
        }
        String[] carPlateIdArr = carPlateIds.split(",");
        for (String carPlagetId : carPlateIdArr) {
            BigdataCarRealtimeGps gps = (BigdataCarRealtimeGps) redisUtil.hget(
                    RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY, carPlagetId);
            if (gps != null) {
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
                result.put(carPlagetId, gpsSimple);
            }
        }

        return result;


    }

    /**
     * 查询实时的定位信息
     */
    @RequestMapping(value = "/loadCarGps")
    @ResponseBody
    public BigdataCarRealtimeSimple loadCarGps(
            @RequestBody String carPlateId) {
        BigdataCarRealtimeGps gps = (BigdataCarRealtimeGps) redisUtil.hget(
                RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY, carPlateId);
        if (gps != null) {
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
            return gpsSimple;
        }
        return null;
    }

    /**
     * @Author WangZhen
     * @Description 读取试试定位文件写回到输出流中
     * 写出文件带有分隔符
     * @Date 2020/4/26 10:43
     **/
    @RequestMapping(value = "/loadRealGpsFileStr")
    @ResponseBody
    public String loadRealGpsFileStr(){
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(dataRealTimeGpsFilePath), "GBK");
            br = new BufferedReader(isr);
            String temLine = null;
            while ((temLine = br.readLine()) != null) {
                sb.append(temLine).append("@#@");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * @Author WangZhen
     * @Description 读取试试定位文件写回到输出流中
     * 写出文件带有分隔符
     * @Date 2020/4/26 10:43
     **/
    @RequestMapping(value = "/loadRealGpsFileStream")
    public void loadRealGpsFileStream(HttpServletResponse response)  {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dataRealTimeGpsFilePath),"GBK"));
            bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            String line =null;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 查询所有车的定位信息
     */
    @RequestMapping(value = "/searchAllCarInfo")
    public Map<String, Object> searchAllCarInfo() {
        Map<Object, Object> carMap = redisUtil.hmget(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY);
        List<BigdataCarRealtimeSimple> bigdataCarRealtimeSimpleList = new ArrayList<>();
        Collection<Object> values = carMap.values();
        for (Object obj : values) {
            if (obj instanceof BigdataCarRealtimeGps) {
                BigdataCarRealtimeGps gps = (BigdataCarRealtimeGps) obj;
                if (gps != null) {
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
                    bigdataCarRealtimeSimpleList.add(gpsSimple);
                }
            }
        }
        Map<String,Object> result = new HashMap<>();
        result.put("data", bigdataCarRealtimeSimpleList);
        return result;
    }


}
