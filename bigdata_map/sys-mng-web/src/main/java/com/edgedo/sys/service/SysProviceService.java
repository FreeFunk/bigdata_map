package com.edgedo.sys.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.mapper.SysProviceMapper;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.queryvo.SysProviceView;
import com.edgedo.sys.queryvo.SysProviceViewSyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysProviceService {
	
	
	@Autowired
	private SysProviceMapper mapper;
	@Autowired
	private SysCityService sysCityService;
	@Autowired
	private SysXianquService sysXianquService;

	
	public List<SysProviceView> listPage(SysProviceQuery query, String cityId, String xianquId){
		List<SysProviceView> list = null;
		if(!(cityId==null||"".equals(cityId))){
			SysCity sysCity = sysCityService.loadById(cityId);
			list = mapper.listPage(query);
			for(SysProviceView sysProvice : list){
				if(sysCity.getProvinceId().equals(sysProvice.getId())){
					list.remove(sysProvice);
					list.add(0,sysProvice);
					break;
				}
			}
		}else if(!(xianquId==null||"".equals(xianquId))){
			SysXianqu sysXianqu = sysXianquService.loadById(xianquId);
			list = mapper.listPage(query);
			for(SysProviceView sysProvice : list){
				if(sysXianqu.getProvinceId().equals(sysProvice.getId())){
					list.remove(sysProvice);
					list.add(0,sysProvice);
					break;
				}
			}
		}else {
			list = mapper.listPage(query);
		}
		query.setList(list);
		return list;
	}

	/*
	查询出所有的省份
	 */
	public List<SysProviceView> selectAll(SysProviceQuery query){
		List<SysProviceView> list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/*
	* 自写的查询
	* */
	public SysProvice select(String provice){
		SysProvice sysProvice = mapper.selectById(provice);
		return sysProvice;
	}
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysProvice voObj) {
		//重复检查
		SysProviceQuery sysProviceQuery = new SysProviceQuery();
		SysProviceView sysProviceView = new SysProviceView();
		sysProviceView.setName(voObj.getName());
		sysProviceQuery.setQueryObj(sysProviceView);
		List list = mapper.listPage(sysProviceQuery);
		if(list.size()>0){
			return "该省份已存在!";
		}
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysProvice voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysProvice voObj) {
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

		sysCityService.selectAndDelete(ids);
		return mapper.deleteBatchIds(ids);
	}
	public List selectByName(String provinceName){
		List list = mapper.selectByName(provinceName);
		return list;
	}
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysProvice loadById(String id) {
		return mapper.selectById(id);
	}
	public List selectByParentId(String parentId){
		List menuList = mapper.selectByParentId(parentId);
		recursive(menuList);
		Collections.sort(menuList, new Comparator<SysProviceView>() {
			@Override
			public int compare(SysProviceView o1, SysProviceView o2) {
				return o1.getOrderNumber().compareTo(o2.getOrderNumber());
			}
		});
		return menuList;
	}

	private void recursive(List<SysProviceViewSyn> list){

		for(SysProviceViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			recursive(pmv.getChildren());
		}
	}
}
