package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.BigdataAlarmRecord;

import java.math.BigDecimal;

public class BigdataAlarmRecordView extends BigdataAlarmRecord {

    private Integer groupCount;

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }
}
