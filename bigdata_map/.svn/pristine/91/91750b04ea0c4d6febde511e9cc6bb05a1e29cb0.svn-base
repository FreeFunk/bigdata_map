package com.edgedo.common.base;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomerDateEditor extends PropertyEditorSupport {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final DateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final boolean allowEmpty;
    private final int exactDateLength;

    public CustomerDateEditor( boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public CustomerDateEditor(boolean allowEmpty, int exactDateLength) {
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if(this.allowEmpty && !StringUtils.hasText(text)) {
            this.setValue((Object)null);
        } else {
            if(text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
                throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
            }

            try {
                if(text.length()==10){
                    this.setValue(this.dateFormat.parse(text));
                }else if(text.length()==19){
                    this.setValue(this.dateFormatFull.parse(text));
                }else{
                    throw new IllegalArgumentException("日期格式错误");
                }

            } catch (ParseException var3) {
                throw new IllegalArgumentException("Could not parse date: " + var3.getMessage(), var3);
            }
        }

    }

    public String getAsText() {
        Date value = (Date)this.getValue();
        return value != null?this.dateFormat.format(value):"";
    }
}

