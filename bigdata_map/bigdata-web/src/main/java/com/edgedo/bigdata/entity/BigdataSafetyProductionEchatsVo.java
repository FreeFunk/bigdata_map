package com.edgedo.bigdata.entity;

import com.edgedo.bigdata.queryvo.BigdataSafetyCheckView;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationView;


public class BigdataSafetyProductionEchatsVo {

    private BigdataSafetyProductionSituationView bigdataSafetyProductionSituationView ;

    private BigdataSafetyProductionSituationView bigdataSafetyProductionSituationViewLast ;

    private BigdataSafetyCheckView bigdataSafetyCheckView;

    public BigdataSafetyProductionSituationView getBigdataSafetyProductionSituationView() {
        return bigdataSafetyProductionSituationView;
    }

    public void setBigdataSafetyProductionSituationView(BigdataSafetyProductionSituationView bigdataSafetyProductionSituationView) {
        this.bigdataSafetyProductionSituationView = bigdataSafetyProductionSituationView;
    }

    public BigdataSafetyProductionSituationView getBigdataSafetyProductionSituationViewLast() {
        return bigdataSafetyProductionSituationViewLast;
    }

    public void setBigdataSafetyProductionSituationViewLast(BigdataSafetyProductionSituationView bigdataSafetyProductionSituationViewLast) {
        this.bigdataSafetyProductionSituationViewLast = bigdataSafetyProductionSituationViewLast;
    }

    public BigdataSafetyCheckView getBigdataSafetyCheckView() {
        return bigdataSafetyCheckView;
    }

    public void setBigdataSafetyCheckView(BigdataSafetyCheckView bigdataSafetyCheckView) {
        this.bigdataSafetyCheckView = bigdataSafetyCheckView;
    }
}
