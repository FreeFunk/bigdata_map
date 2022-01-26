package com.edgedo.util;


/**
 * 坐标工具类
 * 
 * @author songqingtao
 * 
 */
public class CoordinateUtil {
	private static String ak = "0Bcded70772ae9218fc6bb64aa3725c2";
	/**
	 * 赤道半径(单位m)
	 */
	private static final double EARTH_RADIUS = 6378137;

	/**
	 * 转化为弧度(rad)
	 * */
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 基于余弦定理求两经纬度距离
	 * 
	 * @param lng1
	 *            第一点的经度
	 * @param lat1
	 *            第一点的纬度
	 * @param lng2
	 *            第二点的经度
	 * @param lat2
	 *            第二点的纬度
	 * @return 返回的距离，单位 : m
	 * */
	public static double getDistatce(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * 取得距离范围内的坐标范围
	 * 
	 * @param lng
	 *            中心经度
	 * @param lat
	 *            中心纬度
	 * @param raidus
	 *            单位米 return minLat,minLng,maxLat,maxLng
	 */
	public static double[] getAround(double lng, double lat, double raidus) {

		Double latitude = lat;
		Double longitude = lng;

		// 赤道周长24901英里 1609是转换成米的系数
		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}



	/**省份名称去掉：市、省、自治区
	 * @param province
	 * @return
	 */
	private static String getProviceName(String province){
		String result = "";
		if(province.indexOf("市")>-1){
			result = province.substring(0, province.indexOf("市"));
		}else if(province.indexOf("省")>-1){
			result = province.substring(0, province.indexOf("省"));
		}else if(province.indexOf("区")>-1){
			if(province.indexOf("内蒙古")>-1){
				result = "内蒙古";
			}else if(province.indexOf("广西")>-1){
				result = "广西";
			}else if(province.indexOf("西藏")>-1){
				result = "西藏";
			}else if(province.indexOf("宁夏")>-1){
				result = "宁夏";
			}else if(province.indexOf("新疆")>-1){
				result = "新疆";
			}else if(province.indexOf("香港")>-1){
				result = "香港";
			}else if(province.indexOf("澳门")>-1){
				result = "澳门";
			}
		}
		return result;
	}
	/**城市名字去掉市字
	 * @param city
	 * @return
	 */
	private static String getCityName(String city){
		String result = "";
		if(city.indexOf("市")>-1){
			result = city.substring(0, city.indexOf("市"));
		}
		return result;
	}


	//GCJ-02转换BD-09
	/**坐标系转换
	 * @param lng
	 * @param lat
	 * @return
	 */
	private static double[] GCJTobaidu(double lng, double lat){
		double v = Math.PI * 3000.0 / 180.0;
		double x = lng;
		double y = lat;

		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * v);		
		double t = Math.atan2(y, x) + 0.000003 * Math.cos(x * v);
		
		double lng_r = z * Math.cos(t) + 0.0065;
		double lat_r = z * Math.sin(t) + 0.006;
		
		double[] result = new double[2];
		result[0] = lng_r;
		result[1] = lat_r;
		return result;
	}
	
	//BD-09转换GCJ-02
	/**坐标系转换
	 * @param lng
	 * @param lat
	 * @return
	 */
	private static double[] baiduToGCJ(double lng, double lat){
		double v = Math.PI * 3000.0 / 180.0;
		double x = lng - 0.0065;
		double y = lat - 0.006;

		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * v);		
		double t = Math.atan2(y, x) - 0.000003 * Math.cos(x * v);
		
		double lng_r = z * Math.cos(t);
		double lat_r = z * Math.sin(t);
		
		double[] result = new double[2];
		result[0] = lng_r;
		result[1] = lat_r;
		return result;
	}
}
