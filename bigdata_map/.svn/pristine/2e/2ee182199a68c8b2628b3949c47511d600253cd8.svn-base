package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataSafetyWarningFile;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningFileQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningFileView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataSafetyWarningFileMapper  extends BaseMapper<BigdataSafetyWarningFile>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyWarningFileView> listPage(BigdataSafetyWarningFileQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyWarningFileView> listByObj(BigdataSafetyWarningFileQuery query);

	public List<BigdataSafetyWarningFile> selectByWarningInfo(BigdataSafetyWarningFileQuery query);
	

}