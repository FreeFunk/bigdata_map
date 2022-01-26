package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.SysUser;

public class SysUserView extends SysUser {
	
	

	
    private String homePage;

    private String homePageTitle;

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getHomePageTitle() {
		return homePageTitle;
	}

	public void setHomePageTitle(String homePageTitle) {
		this.homePageTitle = homePageTitle;
	}

	

}
