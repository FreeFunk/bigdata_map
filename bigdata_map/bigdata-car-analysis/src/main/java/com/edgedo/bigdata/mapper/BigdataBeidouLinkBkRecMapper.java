package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouLinkBkRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataBeidouLinkBkRecMapper extends BaseMapper<BigdataBeidouLinkBkRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouLinkBkRecView> listPage(BigdataBeidouLinkBkRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouLinkBkRecView> listByObj(BigdataBeidouLinkBkRecQuery query);


    BigdataBeidouLinkBkRec selectByTime(Map<String, Object> map);

    Integer sumLinkMinNum(Map<String, Object> param4);
}