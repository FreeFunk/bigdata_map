package com.edgedo.sys.service;

import java.util.*;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.mapper.SysCityMapper;
import com.edgedo.sys.queryvo.SysCityQuery;
import com.edgedo.sys.queryvo.SysCityView;
import com.edgedo.sys.queryvo.SysCityViewSyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysCityService {
	
	
	@Autowired
	private SysCityMapper mapper;
	@Autowired
	private SysProviceService sysProviceService;
	@Autowired
	private SysXianquService sysXianquService;

	
	public List<SysCityView> listPage(SysCityQuery query, String xianquId){
		List<SysCityView> list = null;
//		query.getQueryObj().setStatus("启用");
		if(!(xianquId==null||"".equals(xianquId))){
			SysXianqu sysXianqu = sysXianquService.loadById(xianquId);
			query.getQueryObj().setProvinceId(sysXianqu.getProvinceId());
			list = mapper.listPage(query);
			for(SysCityView sysCityView : list){
				if(sysXianqu.getCityId().equals(sysCityView.getId())){
					list.remove(sysCityView);
					list.add(0,sysCityView);
					break;
				}
			}
		}else {
			list = mapper.listPage(query);
		}
		query.setList(list);
		return list;
	}

	public List<SysCityView> listByObj(SysCityQuery query){
		List<SysCityView> list = mapper.listByObj(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysCity voObj) {
		//检查重复
		SysCityQuery sysCityQuery = new SysCityQuery();
		SysCityView sysCityView = new SysCityView();
		sysCityView.setName(voObj.getName());
		sysCityQuery.setQueryObj(sysCityView);
		if(mapper.listPage(sysCityQuery).size()>0){
			return "该城市已存在!";
		}
		voObj.setId(Guid.guid());
		String provinceId = voObj.getProvinceId();
		SysProvice sysProvice = sysProviceService.select(provinceId);
		voObj.setProvinceNane(sysProvice.getName());
		if ("on".equals(voObj.getStatus())){
			voObj.setStatus("启用");
		}else {
			voObj.setStatus("停用");
		}
		mapper.insert(voObj);
		return "";
	}
	/***
	 * 查询并删除城市
	 */

	public void selectAndDelete(List<String> ids) {
		sysXianquService.selectAndDeleteProvnice(ids);
		List<SysCityView> sysCityList = new ArrayList<SysCityView>();
		SysCityView sysCity = new SysCityView();
		for(String id:ids){
			sysCity.setProvinceId(id);
			sysCityList.add(sysCity);
		}
		SysCityQuery sysCityQuery = new SysCityQuery();
		sysCityQuery.setList(sysCityList);
		List<SysCityView> list = mapper.listPage(sysCityQuery);
		List<String> idList = new ArrayList<String>();
		for (SysCityView sysCityView:list){
			idList.add(sysCityView.getId());
		}
		if(idList.size()>0) {
			mapper.deleteBatchIds(idList);
		}
	}

	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysCity voObj) {
		String provinceId = voObj.getProvinceId();
		SysProvice sysProvice = sysProviceService.select(provinceId);
		voObj.setProvinceNane(sysProvice.getName());
		if ("on".equals(voObj.getStatus())||"启用".equals(voObj.getStatus())){
			voObj.setStatus("启用");
		}else {
			voObj.setStatus("停用");
		}
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysCity voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		sysXianquService.selectAndDeleteCity(ids);
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysCity loadById(String id) {
		return mapper.selectById(id);
	}
	public List selectByParentId(String parentId){
		List menuList = mapper.selectByParentId(parentId);
		recursive(menuList);
		Collections.sort(menuList, new Comparator<SysCityView>() {
			@Override
			public int compare(SysCityView o1, SysCityView o2) {
				return o1.getOrderNumber().compareTo(o2.getOrderNumber());
			}
		});
		return menuList;
	}

	private void recursive(List<SysCityViewSyn> list){

		for(SysCityViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			recursive(pmv.getChildren());
		}
	}

	/**
	 * 查询所有的城市
	 * @return
	 */
    public List<SysCityView> selectAllCity() {
		return mapper.selectAllCity();
    }

	/**
	 * 根据省份查询省份的城市
	 * @param provinceId
	 * @return
	 */
	public List<SysCityView> selectCityByProvinceId(String provinceId) {
		return mapper.selectCityByProvinceId(provinceId);
	}
}
