<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.${className};
import com.edgedo.bigdata.queryvo.${className}Query;
import com.edgedo.bigdata.queryvo.${className}View;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ${className}Mapper  extends BaseMapper<${className}>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<${className}View> listPage(${className}Query query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<${className}View> listByObj(${className}Query query);
	
	

}