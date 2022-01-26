package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.queryvo.SysCityQuery;
import com.edgedo.sys.queryvo.SysCityView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCityMapper  extends BaseMapper<SysCity> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysCityView> listPage(SysCityQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysCityView> listByObj(SysCityQuery query);

	public List<SysCityView> selectByParentId(String parentId);

	/**
	 * 查询所有的城市
	 * @return
	 */
    List<SysCityView> selectAllCity();

	/**
	 * 根据省份查询城市
	 * @param provinceId
	 * @return
	 */
	List<SysCityView> selectCityByProvinceId(String provinceId);

}