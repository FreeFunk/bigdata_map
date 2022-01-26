package com.edgedo.sys.service;

import java.util.*;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.mapper.SysXianquMapper;
import com.edgedo.sys.queryvo.SysXianquQuery;
import com.edgedo.sys.queryvo.SysXianquView;
import com.edgedo.sys.queryvo.SysXianquViewSyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysXianquService {
	
	
	@Autowired
	private SysXianquMapper mapper;
	@Autowired
	private SysProviceService sysProviceService;
	@Autowired
	private SysCityService sysCityService;

	
	public List<SysXianquView> listPage(SysXianquQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/**
	 * 根据城市id获取下面的县区
	 */
	public List<SysXianquView> selectXianquByCity(String cityId){
		List<SysXianquView> list = mapper.selectXianquByCityId(cityId);
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysXianqu voObj) {
		//检查重复
		SysXianquQuery sysXianquQuery = new SysXianquQuery();
		SysXianquView sysXianquView = new SysXianquView();
		sysXianquView.setName(voObj.getName());
		sysXianquQuery.setQueryObj(sysXianquView);
		String provinceId = voObj.getProvinceId();
		//根据省id插入省名
		SysProvice sysProvice = sysProviceService.select(provinceId);
		voObj.setProvinceName(sysProvice.getName());
		//根据市id插入市名
		SysCity sysCity=sysCityService.loadById(voObj.getCityId());
		voObj.setCityName(sysCity.getName());
		if(mapper.listPage(sysXianquQuery).size()>0){
			return "该县区已添加";
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
	public String update(SysXianqu voObj) {
		String provinceId = voObj.getProvinceId();
		//根据省id插入省名
		SysProvice sysProvice = sysProviceService.select(provinceId);
		voObj.setProvinceName(sysProvice.getName());
		//根据市id插入市名
		SysCity sysCity=sysCityService.loadById(voObj.getCityId());
		voObj.setCityName(sysCity.getName());
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysXianqu voObj) {
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
		
		return mapper.deleteBatchIds(ids);
	}

	/**
	 * 查询并删除
	 */
	public void selectAndDeleteProvnice(List<String> ids) {
		List<SysXianquView> sysXianquList = new ArrayList<SysXianquView>();
		SysXianquView sysXianqu= new SysXianquView();
		for(String id:ids){
			sysXianqu.setProvinceId(id);
			sysXianquList.add(sysXianqu);
		}
		SysXianquQuery sysXianquQuery = new SysXianquQuery();
		sysXianquQuery.setList(sysXianquList);
		List<SysXianquView> list = mapper.listPage(sysXianquQuery);
		List<String> idList = new ArrayList<String>();
		for (SysXianquView sysXianquView:list){
			idList.add(sysXianquView.getId());
		}
		if(idList.size()>0) {
			mapper.deleteBatchIds(idList);
		}
	}
	public void selectAndDeleteCity(List<String> ids) {
		List<SysXianquView> sysXianquList = new ArrayList<SysXianquView>();
		SysXianquView sysXianqu= new SysXianquView();
		for(String id:ids){
			sysXianqu.setCityId(id);
			sysXianquList.add(sysXianqu);
		}
		SysXianquQuery sysXianquQuery = new SysXianquQuery();
		sysXianquQuery.setList(sysXianquList);
		List<SysXianquView> list = mapper.listPage(sysXianquQuery);
		List<String> idList = new ArrayList<String>();
		for (SysXianquView sysXianquView:list){
			idList.add(sysXianquView.getId());
		}
		mapper.deleteBatchIds(idList);
	}
	/**
	 * 加载单个
	 * @param id
	 */
	public SysXianqu loadById(String id) {
		return mapper.selectById(id);
	}

	//加载单个 param name
	public SysXianqu loadByName(String name){
		SysXianqu xianqu = new SysXianqu();
		xianqu.setName(name);
		return mapper.selectOne(xianqu);
	}

	public List selectByParentId(String parentId){
		List menuList = new ArrayList();
		if(sysProviceService.loadById(parentId)==null) {
			if(sysCityService.loadById(parentId)==null) {
				if(parentId.equals("ROOT")) {
					menuList = sysProviceService.selectByParentId(parentId);
				}else {}
			}else {
				menuList = mapper.selectByParentId(parentId);
				recursive(menuList);
				Collections.sort(menuList, new Comparator<SysXianquView>() {
					@Override
					public int compare(SysXianquView o1, SysXianquView o2) {
						return o1.getOrderNumber().compareTo(o2.getOrderNumber());
					}
				});
			}
		}else {
			menuList = sysCityService.selectByParentId(parentId);
		}
		return menuList;
	}
	private void recursive(List<SysXianquViewSyn> list){

		for(SysXianquViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			recursive(pmv.getChildren());
		}
	}

	/**
	 * 获得系统中所有的县区
	 * @return
	 */
    public List<SysXianquView> selectAllXianqu() {
		return mapper.selectAllXianqu();
    }

	/**
	 * 根据城市获得县区
	 * @param userCityId
	 * @return
	 */
    public List<SysXianquView> listAllXianquByCityId(String userCityId) {
		return mapper.selectXianquByCityId(userCityId);
    }
}
