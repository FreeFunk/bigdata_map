package com.edgedo.common.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class HeartDataMap {
	public static final  HeartDataMap IT =new HeartDataMap();
	
	public Map<String, String[]> lastHeartDataMap = new LinkedHashMap();
	
	  public void put(String tnumber, String[] data)
	  {
	    this.lastHeartDataMap.put(tnumber, data);
	  }

	  public Map getData()
	  {
	    return lastHeartDataMap;
	  }

	  public Map<String, String[]> cloneMap()
	  {
	    Map map = new LinkedHashMap();
	    synchronized (this.lastHeartDataMap) {
	      map.putAll(this.lastHeartDataMap);
	    }
	    return map;
	  }
}
