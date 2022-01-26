package com.edgedo.sys.queryvo;



import com.edgedo.common.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

public class SysMenueViewSyn extends SysMenueView{




	public static SysMenueViewSyn genSysMenueViewSyn(SysMenueView view){
		SysMenueViewSyn obj = new SysMenueViewSyn();
		ObjectUtil.copyBeanChange(obj,view,"id,text,path,parentId,type,isLeaf,sortNum,dataState,iconCls");
		return obj;
	}
	private String label;
	//判断是否菜单和用户有关联
	private Boolean checked = null;
	private String nodeCheck ;

	private String name;

	private String title;
	private String value;
	private List<SysMenueViewSyn> data = new ArrayList<SysMenueViewSyn>();


	public String getName() {
		return name;
	}

	public void setName() {
		this.name = this.getText();
	}

	public String getNodeCheck() {
		return nodeCheck;
	}

	public void setNodeCheck(String nodeCheck) {
		this.nodeCheck = nodeCheck;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = true;
		this.nodeCheck = "check";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle() {
		this.title = this.getText();
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue() {
		this.value = this.getId();
	}
	public void setValue(String value) {
		this.value = value;
	}

	public List<SysMenueViewSyn> getData() {
		return data;
	}

	public void setData(List<SysMenueViewSyn> data) {
		this.data = data;
	}

	private List<SysMenueViewSyn> children = new ArrayList<SysMenueViewSyn>();

	public List<SysMenueViewSyn> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenueViewSyn> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel() {
		this.label = this.getText();
	}
	
}
