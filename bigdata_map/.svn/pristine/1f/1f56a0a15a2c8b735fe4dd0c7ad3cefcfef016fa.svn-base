package com.edgedo.sys.service;

import java.util.List;

import com.edgedo.sys.entity.SysDictionaryKey;
import com.edgedo.sys.mapper.SysDictionaryKeyMapper;
import com.edgedo.sys.queryvo.SysDictionaryKeyQuery;
import com.edgedo.sys.queryvo.SysDictionaryKeyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysDictionaryKeyService {
	
	
	@Autowired
	private SysDictionaryKeyMapper mapper;

	
	public List<SysDictionaryKeyView> listPage(SysDictionaryKeyQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysDictionaryKey voObj) {
		//voObj.setId(Guid.guid());
		if(!voObj.getParentId().equals("ROOT")) {
			SysDictionaryKey sysDictionaryKey = mapper.selectById(voObj.getParentId());
			if (sysDictionaryKey.getIsLeaf() == 1) {
				sysDictionaryKey.setIsLeaf(0);
				mapper.updateById(sysDictionaryKey);
			}
		}
		voObj.setIsLeaf(1);
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysDictionaryKey voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysDictionaryKey voObj) {
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
	public String deleteByIds(List<String> ids) {
		for (String id : ids) {
			List list = mapper.selectByParentId(id);
			if (list != null && list.size() > 0) {
				return "删除失败,存在子树";
			}
			mapper.deleteById(id);
		}

		/*mapper.deleteBatchIds(ids);*/

		return "";
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysDictionaryKey loadById(String id) {
		return mapper.selectById(id);
	}

	public List<SysDictionaryKeyView> selectByParentId(String parentId) {
		// TODO Auto-generated method stub
		return mapper.selectByParentId(parentId);
	}


	/**
	 * 加载父节点
	 * @param id
	 */
	public SysDictionaryKey loadparentById(String id) {
		SysDictionaryKey sysDictionaryKey=mapper.selectById(mapper.selectById(id).getParentId());
		return sysDictionaryKey;

	}

}
