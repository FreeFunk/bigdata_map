package com.edgedo.score;

import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.entity.BigdataBeidouCheckStandard;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.service.BigdataBeidouCheckStandardService;
import com.edgedo.common.util.IocUtil;

import java.math.BigDecimal;

/**
 * @ClassName ComputeLinkRate
 * @Description 计算轨迹完整率得分
 * @Author 床前明月光
 * @Date 2019/8/21 15:02
 **/
public class ComputeTraceCompleteRate implements Standard {

    @Override
    public BigdataBeidouCheckScoreRec computeScore(BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck, String id) {
        BigdataBeidouCheckStandardService bigdataBeidouCheckStandardService = IocUtil.getBean(BigdataBeidouCheckStandardService.class);
        BigdataBeidouCheckStandard bigdataBeidouCheckStandard = bigdataBeidouCheckStandardService.loadById(id);

        BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec = new BigdataBeidouCheckScoreRec();
        bigdataBeidouCheckScoreRec.setCompId(bigdataBeidouCompMonthCheck.getCompId());
        bigdataBeidouCheckScoreRec.setCompName(bigdataBeidouCompMonthCheck.getCompName());
        bigdataBeidouCheckScoreRec.setOwnerMonthCompCheckId(bigdataBeidouCompMonthCheck.getId());
        bigdataBeidouCheckScoreRec.setOwnerScoreStandard(bigdataBeidouCheckStandard.getId());
        bigdataBeidouCheckScoreRec.setStandardName(bigdataBeidouCheckStandard.getStandardName());
        bigdataBeidouCheckScoreRec.setStandardDirection(bigdataBeidouCheckStandard.getStandardDirection());
        bigdataBeidouCheckScoreRec.setScoreLine(bigdataBeidouCheckStandard.getScoreLine());
        bigdataBeidouCheckScoreRec.setUnscoreLine(bigdataBeidouCheckStandard.getUnscoreLine());
        bigdataBeidouCheckScoreRec.setScoreNum(bigdataBeidouCheckStandard.getScoreNum());
        bigdataBeidouCheckScoreRec.setCountMonth(bigdataBeidouCompMonthCheck.getCountMonth());
        bigdataBeidouCheckScoreRec.setYearNum(bigdataBeidouCompMonthCheck.getYearNum());
        //运营商联通率
        bigdataBeidouCheckScoreRec.setRealNum(bigdataBeidouCompMonthCheck.getTraceCompleteRate());
        BigDecimal traceCompleteRate = bigdataBeidouCompMonthCheck.getTraceCompleteRate();

        String standardDirection = bigdataBeidouCheckStandard.getStandardDirection();
        BigDecimal scoreLine = bigdataBeidouCheckStandard.getScoreLine();
        BigDecimal unscoreLine = bigdataBeidouCheckStandard.getUnscoreLine();
        BigDecimal scoreNum = bigdataBeidouCheckStandard.getScoreNum();
        BigDecimal score = new BigDecimal("0");
        if(standardDirection.equals("0")){
            if(traceCompleteRate.compareTo(unscoreLine)>0){
                score = (traceCompleteRate.subtract(unscoreLine)).divide(scoreLine.subtract(unscoreLine),2,BigDecimal.ROUND_HALF_UP).multiply(scoreNum);
            }
        }else {
            if(traceCompleteRate.compareTo(unscoreLine)<0){
                score = (traceCompleteRate.subtract(unscoreLine)).divide(scoreLine.subtract(unscoreLine),2,BigDecimal.ROUND_HALF_UP).multiply(scoreNum);
            }
        }
        bigdataBeidouCheckScoreRec.setRealScore(score);
        return bigdataBeidouCheckScoreRec;
    }
}
