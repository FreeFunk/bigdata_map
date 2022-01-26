package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.entity.YwTrainLession;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecQuery;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataPushLearnRecMapper extends BaseMapper<BigdataPushLearnRec>{
	
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

    int countSafetyRec(Map<String, Object> map);

	List<YwTrainLession> getLessionByClsId(String clsId);

	BigdataPushLearnRec selectByVo(BigdataPushLearnRec bigdataPushLearnRec);

	void updateNew(BigdataPushLearnRec bigdataPushLearnRec);

    List<BigdataPushLearnRec> selectUnLearnRec(int yearNum);
}