package com.edgedo.reportdata.controller;


import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.reportdata.entity.SafetyTrainingCarNum;
import com.edgedo.reportdata.queryvo.SafetyTrainingCarDetailQuery;
import com.edgedo.reportdata.service.SafetyTrainingCarNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/safetyTrainingcarnum")
public class SafetyTrainingCarNumController extends BaseController{

    @Autowired
    private SafetyTrainingCarNumService safetyTrainingCarNumService;

    @RequestMapping(value = "/selectObjByCityId",method = RequestMethod.POST)
    @Pass
    public ModelAndView selectObjByCityId(String cityId,String tongjiType,Date searchTime) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询书当月的统计记录
        SafetyTrainingCarNum safetyTrainingCarNum = new SafetyTrainingCarNum();
        safetyTrainingCarNum.setCityId(cityId);
        safetyTrainingCarNum.setTongjiTime(searchTime);
        safetyTrainingCarNum.setTongjiType(tongjiType);

        List<SafetyTrainingCarNum> safetyTrainingCarNumList = safetyTrainingCarNumService.selectObjByCityId(safetyTrainingCarNum);
        return buildResponse(modelAndView,safetyTrainingCarNumList);
    }


    @RequestMapping(value = "/listPageFinisheSafetyTrainingCarDetail",method = RequestMethod.POST)
    @Pass
    public ModelAndView listPageFinisheSafetyTrainingCar(@ModelAttribute SafetyTrainingCarDetailQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询统计类型
        String searchType = query.getSearchType();
        if(searchType == null || searchType.equals("")){
            return buildErrorResponse(modelAndView,"查询统计类型不能为空！");
        }
        //查询时间
        Date searchTime = query.getSearchTime();
        if(searchTime == null ){
            return buildErrorResponse(modelAndView,"查询时间不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        safetyTrainingCarNumService.listPageFinisheSafetyTrainingCarDetail(query);
        return buildResponse(modelAndView,query);
    }



}
