package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.AlarmVo;
import com.edgedo.bigdata.entity.BigdataSafetyWarning;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataSafetyWarningMapper extends BaseMapper<BigdataSafetyWarning>{

    //根据主键统计
    int countById(BigdataSafetyWarning warning);

    //根据分片字段修改
    void updateByPkSelectiveAndFenPian(BigdataSafetyWarning warning);

    //根据分片字段修改
    void updateByPkSelectiveAndFenPianNew(BigdataSafetyWarning warning);

    int countByCarPlateNum(Map<String, Object> map);

    List<AlarmVo> countByCarType(Map<String, Object> map);

    List<AlarmVo> countByCarTypeMonth(Map<String, Object> map);

    List<AlarmVo> countByTeamTransitType(Map<String, Object> map);

    int countHandleNumByCarPlateNum(Map<String, Object> map);

    int selectAlarmNumDay(@Param("yearNum")Integer yearNum,
                                    @Param("countMonth")Integer countMonth,
                                    @Param("countDay")Integer countDay,
                                    @Param("xianQuId")String xianQuId,
                                    @Param("carType")String carType,
                                    @Param("startTime")String startTime,
                                    @Param("endTime")String endTime);

    int selectHandlerDay(@Param("yearNum")Integer yearNum,
                          @Param("countMonth")Integer countMonth,
                          @Param("countDay")Integer countDay,
                          @Param("xianQuId")String xianQuId,
                          @Param("carType")String carType,
                          @Param("startTime")String startTime,
                          @Param("endTime")String endTime);


    Map<String, String> selectCountType(@Param("countMonth")Integer countMonth,
                                        @Param("countDay")Integer countDay,
                                        @Param("xianQuId")String xianQuId,
                                        @Param("carType")String carType);

    List<AlarmVo> countByTeamTransitTypeMonth(Map<String, Object> map);

    List<AlarmVo> countByTeamTransitTypeTopThree(Map<String, Object> map1);

    List<AlarmVo> countByTeamTransitTypeTopThreeMonth(Map<String, Object> map1);

    int selectWarningTypeCountByQuery(BigdataSafetyWarningQuery query);


    BigdataSafetyWarning selectByBId(Map<String, Object> map);

    int countSafetyNum(Map<String, Object> map);

    int countSumNumByCompId(Map<String, Object> map);
}