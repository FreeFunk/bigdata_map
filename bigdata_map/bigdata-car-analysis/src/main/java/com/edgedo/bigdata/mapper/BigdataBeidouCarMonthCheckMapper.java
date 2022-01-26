package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataBeidouCarMonthCheckMapper extends BaseMapper<BigdataBeidouCarMonthCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarMonthCheckView> listPage(BigdataBeidouCarMonthCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarMonthCheckView> listByObj(BigdataBeidouCarMonthCheckQuery query);


    BigdataBeidouCarMonthCheck selectByVo(BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck);

	void updateNew(BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck1);

	int countOnlineByCompId(Map<String, Object> param);

	int countTraceUncompleteNumByCompId(Map<String, Object> param1);

	int countTraceFlayCarNumByCompId(Map<String, Object> param2);

	int countGpsUploadTimeQualifiedNumByCompId(Map<String, Object> param3);

    int countDriverCardUpNumByCompId(Map<String, Object> param5);
}