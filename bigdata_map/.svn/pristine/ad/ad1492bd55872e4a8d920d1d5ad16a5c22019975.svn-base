package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.SysOrgLevelRole;

import java.util.ArrayList;
import java.util.List;

public class SysOrgLevelRoleView extends SysOrgLevelRole {

    private String name;

    private String text;

    private String treeType;

    private String value;

    private String title;

    private Boolean checked;

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType() {
        this.treeType = "userRoleTree";
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    private List<SysOrgLevelRoleView> data = new ArrayList<>();

    public String getValue() {
        return value;
    }

    public void setValue() {
        this.value = this.getId();
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = this.getRoleName();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SysOrgLevelRoleView> getData() {
        return data;
    }

    public void setData(List<SysOrgLevelRoleView> data) {
        this.data = data;
    }

    private List<SysOrgLevelRoleView> children = new ArrayList<SysOrgLevelRoleView>();

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = this.getRoleName();
    }

    public String getText() {
        return text;
    }
    public void setText() {
        this.text = this.getRoleName();
    }

    public List<SysOrgLevelRoleView> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrgLevelRoleView> children) {
        this.children = children;
    }

}
