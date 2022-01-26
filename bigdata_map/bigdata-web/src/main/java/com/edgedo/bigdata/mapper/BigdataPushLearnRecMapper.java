package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.entity.YwTrainConsumRec;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecQuery;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataPushLearnRecMapper  extends BaseMapper<BigdataPushLearnRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataPushLearnRecView> listPage(BigdataPushLearnRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataPushLearnRecView> listByObj(BigdataPushLearnRecQuery query);


    List<BigdataPushLearnRec> selectByEmpId(BigdataPushLearnRec empId);

    List<YwTrainConsumRec> selectSafetyRec(String stuId);

	String loadByEmpId(String empId);
}