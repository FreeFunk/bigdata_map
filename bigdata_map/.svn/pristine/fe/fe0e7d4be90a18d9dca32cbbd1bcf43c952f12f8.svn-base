package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouLinkBkRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouLinkBkRecMapper  extends BaseMapper<BigdataBeidouLinkBkRec>{
	
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
	
	

}