package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysXianquQuery;
import com.edgedo.sys.queryvo.SysXianquView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysXianquMapper  extends BaseMapper<SysXianqu>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysXianquView> listPage(SysXianquQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysXianquView> listByObj(SysXianquQuery query);



	/**
	 * 获得所有县区
	 * @return
	 */
    List<SysXianquView> selectAllXianqu();

	/**
	 * 根据城市id获得县区列表
	 * @param cityId
	 * @return
	 */
	List<SysXianquView> selectXianquByCityId(String cityId);

	/**
	 * 根据县区名和城市名获得县区记录
	 * @param param
	 * @return
	 */
	SysXianqu selectByXianquNameAndCityName(Map<String, Object> param);

    SysXianqu selectXianQuId(String xianQuId);
}