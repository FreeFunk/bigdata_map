package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.SysCity;

public class SysCityView extends SysCity {

	//判断是否是叶子节点;
	public int isLeaf;

	public int getIsLeaf() {
		return 0;
	}

	public void setIsLeaf() {
		this.isLeaf = 0;
	}


}
