package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BeidouDataInCount;
import com.edgedo.bigdata.queryvo.BeidouDataInCountQuery;
import com.edgedo.bigdata.queryvo.BeidouDataInCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BeidouDataInCountMapper  extends BaseMapper<BeidouDataInCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BeidouDataInCountView> listPage(BeidouDataInCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BeidouDataInCountView> listByObj(BeidouDataInCountQuery query);


    BeidouDataInCountView getbeidouInCountData(BeidouDataInCountQuery query);

	List listpageForBeidouData(BeidouDataInCountQuery query);
}