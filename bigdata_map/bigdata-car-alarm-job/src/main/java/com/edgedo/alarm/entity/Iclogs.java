package com.edgedo.alarm.entity;

/**
 * 轩慧的司机卡插拔卡记录表
 */
public class Iclogs {

    private Integer tid;
    //车牌号
    private String tcarcode;
    //驾驶员
    private String tname;
    //司机卡号
    private String tids;
    //插卡/拔卡（1：插卡2：拔卡）
    private Integer tstauts;
    //插卡/拔卡时间
    private String ttimes;
    //所属公司
    private Integer tcoid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTcarcode() {
        return tcarcode;
    }

    public void setTcarcode(String tcarcode) {
        this.tcarcode = tcarcode;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTids() {
        return tids;
    }

    public void setTids(String tids) {
        this.tids = tids;
    }

    public Integer getTstauts() {
        return tstauts;
    }

    public void setTstauts(Integer tstauts) {
        this.tstauts = tstauts;
    }

    public String getTtimes() {
        return ttimes;
    }

    public void setTtimes(String ttimes) {
        this.ttimes = ttimes;
    }

    public Integer getTcoid() {
        return tcoid;
    }

    public void setTcoid(Integer tcoid) {
        this.tcoid = tcoid;
    }
}
