package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCarTraceBkRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouCarTraceBkRecMapper  extends BaseMapper<BigdataBeidouCarTraceBkRec>{
	
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
	
	

}