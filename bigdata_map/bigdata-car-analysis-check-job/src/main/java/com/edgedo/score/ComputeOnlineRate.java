package com.edgedo.score;

import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.entity.BigdataBeidouCheckStandard;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.service.BigdataBeidouCheckStandardService;
import com.edgedo.common.util.IocUtil;

import java.math.BigDecimal;

/**
 * @ClassName ComputeOnlineRate
 * @Description 计算上线率得分
 * @Author 床前明月光
 * @Date 2019/8/21 9:22
 **/
public class ComputeOnlineRate implements Standard {

    @Override
    public BigdataBeidouCheckScoreRec computeScore(BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck,String id) {
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
        bigdataBeidouCheckScoreRec.setRealNum(bigdataBeidouCompMonthCheck.getOnlineRate());
        bigdataBeidouCheckScoreRec.setCountMonth(bigdataBeidouCompMonthCheck.getCountMonth());
        bigdataBeidouCheckScoreRec.setYearNum(bigdataBeidouCompMonthCheck.getYearNum());
        //运营商上线率
        BigDecimal onlineRate = bigdataBeidouCompMonthCheck.getOnlineRate();

        String standardDirection = bigdataBeidouCheckStandard.getStandardDirection();
        BigDecimal scoreLine = bigdataBeidouCheckStandard.getScoreLine();
        BigDecimal unscoreLine = bigdataBeidouCheckStandard.getUnscoreLine();
        BigDecimal scoreNum = bigdataBeidouCheckStandard.getScoreNum();
        BigDecimal score = new BigDecimal("0");
        if(standardDirection.equals("0")){
            if(onlineRate.compareTo(unscoreLine)>0){
                score = (onlineRate.subtract(unscoreLine)).divide(scoreLine.subtract(unscoreLine),2,BigDecimal.ROUND_HALF_UP).multiply(scoreNum);
            }
        }else {
            if(onlineRate.compareTo(unscoreLine)<0){
                score = (onlineRate.subtract(unscoreLine)).divide(scoreLine.subtract(unscoreLine),2,BigDecimal.ROUND_HALF_UP).multiply(scoreNum);
            }
        }
        bigdataBeidouCheckScoreRec.setRealScore(score);
        return bigdataBeidouCheckScoreRec;
    }

}
