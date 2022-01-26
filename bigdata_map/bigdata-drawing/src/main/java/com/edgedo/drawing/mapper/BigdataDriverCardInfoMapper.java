package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.queryvo.BigdataDriverCardInfoQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCardInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverCardInfoMapper  extends BaseMapper<BigdataDriverCardInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardInfoView> listPage(BigdataDriverCardInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardInfoView> listByObj(BigdataDriverCardInfoQuery query);
	
	

}