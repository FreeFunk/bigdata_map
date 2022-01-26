package com.edgedo.bigdata.service;
		
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.edgedo.bigdata.entity.StopCarGpsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.mapper.BigdataCarRealtimeGpsMapper;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsQuery;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import com.edgedo.common.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BigdataCarRealtimeGpsService {

	@Autowired
	private BigdataCarRealtimeGpsMapper mapper;

	@Value("${gpsUrl}")
	private String gpsUrl;

	
	public List<BigdataCarRealtimeGpsView> listPage(BigdataCarRealtimeGpsQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataCarRealtimeGps voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataCarRealtimeGps voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataCarRealtimeGps voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataCarRealtimeGps loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataCarRealtimeGps> getCarGps(BigdataCarRealtimeGpsQuery query) throws IOException {
		SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
		//获取开始时间和结束时间
		Date startTime = query.getStartTime();
		Date endTime = query.getEndTime();
		String dateIntStr = sdfDateInt.format(startTime);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlate",query.getQueryObj().getCarPlateNum());
		param.put("searchDay",dateIntStr);

		String url = gpsUrl+"/cartrail/loadCarTrail.jsn";

		HttpRequestUtil.HttpResuestResponseStreamWrap res = HttpRequestUtil.postRequestByte(url,param);
		InputStream bis = res.getInputStream();
		InputStreamReader isr=new InputStreamReader(bis, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String line="";
		List<BigdataCarRealtimeGps> bigdataCarRealtimeGpsList = new ArrayList<>();
		while ((line=br.readLine())!=null) {
			BigdataCarRealtimeGps bigdataCarRealtimeGps = fenxiOneRealPosition(line);
			bigdataCarRealtimeGpsList.add(bigdataCarRealtimeGps);
		}
		//根据时间过滤数据
		List<BigdataCarRealtimeGps> carRealtimeGpsList =
				bigdataCarRealtimeGpsList.stream()
						.filter(
								bg -> bg.getLastPositionTime().getTime() > startTime.getTime()
										&& bg.getLastPositionTime().getTime() < endTime.getTime())
						.collect(Collectors.toList());
		//查询
		br.close();
		isr.close();
		bis.close();
		return carRealtimeGpsList;
	}


	public List<StopCarGpsVo> getStopCarGpsPoint(BigdataCarRealtimeGpsQuery query) throws IOException {
		SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
		//获取开始时间和结束时间
		Date startTime = query.getStartTime();
		Date endTime = query.getEndTime();
		String dateIntStr = sdfDateInt.format(startTime);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlate",query.getQueryObj().getCarPlateNum());
		param.put("searchDay",dateIntStr);

		String url = gpsUrl+"/cartrail/loadCarTrail.jsn";

		HttpRequestUtil.HttpResuestResponseStreamWrap res = HttpRequestUtil.postRequestByte(url,param);
		InputStream bis = res.getInputStream();
		InputStreamReader isr=new InputStreamReader(bis, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String line="";
		List<BigdataCarRealtimeGps> bigdataCarRealtimeGpsList = new ArrayList<>();
		while ((line=br.readLine())!=null) {
			BigdataCarRealtimeGps bigdataCarRealtimeGps = fenxiOneRealPosition(line);
			bigdataCarRealtimeGpsList.add(bigdataCarRealtimeGps);
		}
		//根据时间过滤数据
		List<BigdataCarRealtimeGps> carRealtimeGpsList =
				bigdataCarRealtimeGpsList.stream()
						.filter(
								bg -> bg.getLastPositionTime().getTime() > startTime.getTime()
										&& bg.getLastPositionTime().getTime() < endTime.getTime())
						.collect(Collectors.toList());
		int j=1;
		boolean flag = true;
		List<StopCarGpsVo> stopCarGpsVoList = new ArrayList<>();
		for(int i =0;i<carRealtimeGpsList.size();i++){
			do{
				if(j<carRealtimeGpsList.size()){

					BigdataCarRealtimeGps bigdataCarRealtimeGps = carRealtimeGpsList.get(i);
					String pointLat = bigdataCarRealtimeGps.getPointLat().toString();
					String pointLong = bigdataCarRealtimeGps.getPointLong().toString();

					BigdataCarRealtimeGps bigdataCarRealtimeGps1 = carRealtimeGpsList.get(j);
					String pointLat1 = bigdataCarRealtimeGps1.getPointLat().toString();
					String pointLong1 = bigdataCarRealtimeGps1.getPointLong().toString();
					if(pointLat.equals(pointLat1) && pointLong.equals(pointLong1)){
						j=j+1;
						flag = true;
					}else {
						if(j-i>1){
							//计算两点之间的停车时间
							Date lastPositionTime = bigdataCarRealtimeGps.getLastPositionTime();
							BigdataCarRealtimeGps bigdataCarRealtimeGps2 = carRealtimeGpsList.get(j-1);
							Date lastPositionTime1 = bigdataCarRealtimeGps2.getLastPositionTime();
							long countSecond =(lastPositionTime1.getTime()-lastPositionTime.getTime())/1000;
							if((int)countSecond>180){
								StopCarGpsVo stopCarGpsVo = new StopCarGpsVo();
								stopCarGpsVo.setCarPlateNum(bigdataCarRealtimeGps.getCarPlateNum());
								stopCarGpsVo.setPointLat(bigdataCarRealtimeGps.getPointLat());
								stopCarGpsVo.setPointLong(bigdataCarRealtimeGps.getPointLong());
								stopCarGpsVo.setStartTime(lastPositionTime);
								stopCarGpsVo.setEndTime(lastPositionTime1);
								stopCarGpsVo.setCountSecond((int)countSecond);
								stopCarGpsVoList.add(stopCarGpsVo);
							}
						}
						i=j-1;
						j=j+1;
						flag = false;
					}
				}else {
					flag = false;
				}
			}while (flag);
		}
		//查询
		br.close();
		isr.close();
		bis.close();
		return stopCarGpsVoList;
	}

	private BigdataCarRealtimeGps fenxiOneRealPosition(String temLine){
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
		}catch (Exception e){}
		return null;

	}

	public String getGpsUrl() {
		return gpsUrl;
	}

	public void setGpsUrl(String gpsUrl) {
		this.gpsUrl = gpsUrl;
	}
}
