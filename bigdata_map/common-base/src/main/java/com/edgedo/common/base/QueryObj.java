package com.edgedo.common.base;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel(value="分页查询条件",description="分页查询条件")
public class QueryObj implements Serializable {
	//开始页数
	@ApiModelProperty(value="第几页",example="1,2,3,4,5")
	private  Integer page;
	//限制
	@ApiModelProperty(value="每页条数",example="1,2,3,4,5")
	private Integer limit;
	//起始条数
	@ApiModelProperty(value="分页从第几条开始取",example="0,10,20,30,40,50")
	private Integer start;
	//结束条数
	@ApiModelProperty(hidden = true)
	private Integer end;
	//总数
	@ApiModelProperty(hidden = true)
	private Integer totalCount;
	//总页数
	@ApiModelProperty(hidden = true)
	private Integer totalPage;
	//排序
	private String orderBy;
	//列表
	@ApiModelProperty(hidden = true)
	private List list;
	//请求成功或者失败
	@ApiModelProperty(hidden = true)
	private Boolean success = true;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
		this.start = (page-1)*limit;
	}

	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		//最大100条已经够狠了
		if(limit!=null && limit>100){
			this.limit=100;
		}else {
			this.limit = limit;
		}
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		if(limit==null || start==null){
			return null;
		}else{
			return limit;
		}
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		if(totalCount!=null&&limit!=null){
			this.totalPage = totalCount/limit + (totalCount%limit>0 ? 1:0);
		}
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String cacheKey(){
		String key = "start:"+start+"limit:"+limit;
		return key;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
