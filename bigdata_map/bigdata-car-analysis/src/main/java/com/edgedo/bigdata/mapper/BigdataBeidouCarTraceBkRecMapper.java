package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCarTraceBkRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataBeidouCarTraceBkRecMapper extends BaseMapper<BigdataBeidouCarTraceBkRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarTraceBkRecView> listPage(BigdataBeidouCarTraceBkRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarTraceBkRecView> listByObj(BigdataBeidouCarTraceBkRecQuery query);


    int countByCarPlateNum(Map<String, Object> param);
}