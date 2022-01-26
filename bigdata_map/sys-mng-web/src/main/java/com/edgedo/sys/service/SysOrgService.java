package com.edgedo.sys.service;

import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysOrg;
import com.edgedo.sys.mapper.SysOrgMapper;
import com.edgedo.sys.queryvo.SysOrgQuery;
import com.edgedo.sys.queryvo.SysOrgView;
import com.edgedo.sys.queryvo.SysOrgViewSyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysOrgService {
	
	
	@Autowired
	private SysOrgMapper mapper;

	
	public List<SysOrgView> listPage(SysOrgQuery query){
		List<SysOrgView> list = mapper.listPage(query);
		for(SysOrgView s:list){
			String parentId =  s.getParentId();
			if(parentId.equals("ROOT")){
				s.setOwnerOrgName("组织机构");
			}else {
				SysOrg sysOrg = mapper.selectById(s.getParentId());
				if(sysOrg!=null){
					s.setOwnerOrgName(sysOrg.getOrgName());
				}
			}
		}
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	/*public String insert(SysOrg voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}*/
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysOrg voObj) {
		voObj.setId(Guid.guid());
		voObj.setIsLeaf("1");
		String parentId = voObj.getParentId();
		//判断parentId是否是RooT
		if(parentId.equals("ROOT")){
			voObj.setIsLeaf("1");
		}else {
			//根据parentId 查询出父节点
			SysOrg sysOrg = mapper.selectById(parentId);
			if(sysOrg!=null){
				String isLeaf = sysOrg.getIsLeaf();
				//修改父节点的isLeaf
				if(isLeaf.equals("1")){
					sysOrg.setIsLeaf("0");
					mapper.updateById(sysOrg);
				}
			}
		}
		mapper.insert(voObj);
		return "";
	}
	/*public String insert(SysOrg voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}*/
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysOrg voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysOrg voObj) {
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
	//批量删除同时更新父节点的叶子zhuangtai
	public String deleteByIdsAndUpadteParentIsLeaf(List<String> ids) {

		for(String id:ids){
			SysOrg sysOrg = mapper.selectById(id);
			String isLeaf = sysOrg.getIsLeaf();
			if(isLeaf.equals("0")){
				return "请先删除"+sysOrg.getOrgName()+"下的子类";
			}
		}

		for(String id:ids){
			//查询出要删出的对象
			SysOrg sysOrg = mapper.selectById(id);
			if(sysOrg!=null){
				//删除对对象
				mapper.deleteById(id);
				//获取到父节点的ID
				String parentId = sysOrg.getParentId();
				//判断父节点ID是否是ROOT
				if(!parentId.equals("ROOT")){
					//根据父节点查询子节点数量
					List<SysOrgViewSyn> list = mapper.selectByPreantID(parentId);
					if(list.size()==0){
						SysOrg sysOrg1 = mapper.selectById(parentId);
						sysOrg1.setIsLeaf("1");
						mapper.updateById(sysOrg1);
					}
				}
			}
		}
		return "";
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysOrg loadById(String id) {
		return mapper.selectById(id);
	}


	//根据父节节点加载
	public List<SysOrgViewSyn> selectByPreantID(String parentId) {
		return mapper.selectByPreantID(parentId);
	}
}
