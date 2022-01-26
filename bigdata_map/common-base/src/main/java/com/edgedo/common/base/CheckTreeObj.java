package com.edgedo.common.base;

public class CheckTreeObj extends TreeObj{
    private boolean checked = false;

	public boolean isChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        if(checked!=null && !checked.equals("")){
            this.checked=true;
        }else{
            this.checked=false;
        }
    }
}
