package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.reportdata.entity.SafetyTrainingRecEmp;
import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.queryvo.SafetyTrainingConsumRecQuery;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import com.edgedo.reportdata.service.SafetyTrainingConsumRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/safetytrainingconsumrec")
public class SafetyTrainingConsumRecController extends BaseController {

    @Autowired
    private SafetyTrainingConsumRecService safetyTrainingConsumRecService;


    @RequestMapping(value = "/listPage",method = RequestMethod.POST)
    @Pass
    public ModelAndView listPage(@ModelAttribute SafetyTrainingConsumRecQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询统计类型
        String searchType = query.getSearchType();
        if(searchType == null || searchType.equals("")){
            return buildErrorResponse(modelAndView,"查询统计类型不能为空！");
        }
        //查询时间
        Date searchTime = query.getSearchTime();
        if(searchTime == null ){
            query.setSearchTime(new Date());
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        safetyTrainingConsumRecService.listPage(query);
        return buildResponse(modelAndView,query);
    }

    //根据车架号查看详情
    @RequestMapping(value = "/selectCarInfoByCarFrameNum",method = RequestMethod.POST)
    @Pass
    public ModelAndView selectCarInfoByCarFrameNum(@ModelAttribute TransitCarInfoQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //车架号
        String carFrameNum = query.getCarFrameNum();
        if(carFrameNum == null || carFrameNum.equals("")){
            return buildErrorResponse(modelAndView,"车架号不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        TransitCarBaseinfo transitCarBaseinfo = safetyTrainingConsumRecService.selectCarInfoByCarFrameNum(query);
        return buildResponse(modelAndView,transitCarBaseinfo);
    }

    //根据车架号查看详情
    @RequestMapping(value = "/selectLessionDetailByCarFrameNum",method = RequestMethod.POST)
    @Pass
    public ModelAndView selectLessionDetailByCarFrameNum(@ModelAttribute TransitCarInfoQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //车架号
        String carFrameNum = query.getCarFrameNum();
        if(carFrameNum == null || carFrameNum.equals("")){
            return buildErrorResponse(modelAndView,"车架号不能为空！");
        }
        String searchType = query.getSearchType();
        if(searchType==null || searchType.length()==0){
            return buildErrorResponse(modelAndView,"查询统计类型不能为空！");
        }
        Date searchTime = query.getSearchTime();
        if(searchTime==null){
            return buildErrorResponse(modelAndView,"查询统计时间不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        safetyTrainingConsumRecService.selectLessionDetailByCarFrameNum(query);
        return buildResponse(modelAndView,query);
    }


    @RequestMapping(value = "/listPageForTransitCarTeam",method = RequestMethod.POST)
    @Pass
    public ModelAndView listPageForTransitCarTeam(@ModelAttribute TransitCarTeamQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String searchType = query.getSearchType();
        if(searchType==null || searchType.length()==0){
            return buildErrorResponse(modelAndView,"查询统计类型不能为空！");
        }
        Date searchTime = query.getSearchTime();
        if(searchTime==null){
            return buildErrorResponse(modelAndView,"查询统计时间不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        safetyTrainingConsumRecService.listPageForTransitCarTeam(query);
        return buildResponse(modelAndView,query);
    }





}
