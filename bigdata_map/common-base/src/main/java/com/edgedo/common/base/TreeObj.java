package com.edgedo.common.base;

/**
 * Created by wangzhen 树节点对象
 */
public class TreeObj {
    private String text;
    private String id;
    private boolean leaf;
    private String isLeaf;
    private String parentId;
    private String iconCls;
    public TreeObj(){

    }

    public TreeObj(String text,String id , boolean leaf){
        this.text = text;
        this.id = id;
        this.leaf = leaf;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLeaf() {
        if(isLeaf!=null && isLeaf.equals("1")){
            return true;
        }else{
            return false;
        }
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIconCls() {
        if(iconCls==null || iconCls.length()==0){
            if(isLeaf()){
                return "x-fa fa-sitemap";
            }else{
                return "x-fa fa-leaf";
            }

        }
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}
