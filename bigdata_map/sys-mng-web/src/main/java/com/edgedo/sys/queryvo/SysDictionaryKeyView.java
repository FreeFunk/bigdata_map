package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.SysDictionaryKey;

import java.util.ArrayList;
import java.util.List;


public class SysDictionaryKeyView extends SysDictionaryKey {

    private List<SysDictionaryKeyView> children = new ArrayList<SysDictionaryKeyView>();

    private String text;

    private String name;

    private String label;

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = this.getDictName();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel() {
        this.label = this.getDictName();
    }

    public String getText() {
        return text;
    }

    public void setText() {
        this.text = this.getDictName();
    }

    public List<SysDictionaryKeyView> getChildren() {
        return children;
    }

    public void setChildren(List<SysDictionaryKeyView> children) {
        this.children = children;
    }


}
