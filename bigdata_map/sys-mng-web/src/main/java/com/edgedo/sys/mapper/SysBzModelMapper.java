package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysBzModel;
import com.edgedo.sys.queryvo.SysBzModelQuery;
import com.edgedo.sys.queryvo.SysBzModelView;
import com.edgedo.sys.queryvo.SysBzModelViewSyn;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysBzModelMapper  extends BaseMapper<SysBzModel>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysBzModelView> listPage(SysBzModelQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysBzModelView> listByObj(SysBzModelQuery query);


    List<SysBzModelViewSyn> selectBzModelByParentId(String parentId);

	List<SysBzModelViewSyn> selectBzModelById(String id);
}