package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.reportdata.entity.Agent;
import com.edgedo.reportdata.entity.YwTrainChargeBill;
import com.edgedo.reportdata.queryvo.AgentQuery;
import com.edgedo.reportdata.service.AgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/agent")
public class AgentController extends BaseController {

    @Autowired
    private AgentService agentService;

    @RequestMapping("/list")
    @Pass
    public ModelAndView list(@ModelAttribute AgentQuery query) throws Exception {
        String  searchType = query.getSearchType();
        ModelAndView modelAndView = new ModelAndView();
        Agent agent = agentService.selectByQuery(query);
        //查询手机课时数
        //查询电脑学习课时数
        //总的学习人数
        //应审车辆数
        //已审车辆数
        //应审人员数
        //已审人员数
        //充值金额
        //消费金额
        buildResponse(modelAndView);
        return modelAndView;
    }

    //充值详情列表
    @RequestMapping(value = "/listPageForChargeBill",method = RequestMethod.POST)
    @Pass
    public ModelAndView listPageForChargeBill(@ModelAttribute AgentQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询统计类型
//        String searchType = query.getSearchType();
//        if(searchType == null || searchType.equals("")){
//            return buildErrorResponse(modelAndView,"查询统计类型不能为空！");
//        }
        //查询时间
//        Date searchTime = query.getSearchTime();
//        if(searchTime == null ){
//            query.setSearchTime(new Date());
//        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        query.setOrderBy(" PAY_TIME desc ");
        agentService.listPageForChargeBill(query);
        return buildResponse(modelAndView,query);
    }

    //财务日统计查询充值详情列表
    @RequestMapping(value = "/listPageForChargeBillByDay",method = RequestMethod.POST)
    @Pass
    public ModelAndView listPageForChargeBillByDay(@ModelAttribute AgentQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //开始时间
        Date startTime = query.getStartTime();
        if(startTime == null ){
            return buildErrorResponse(modelAndView,"开始时间不能为空！");
        }
        //截止日期
        Date endTime = query.getEndTime();
        if(endTime == null ){
            return buildErrorResponse(modelAndView,"截止时间不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        agentService.listPageForChargeBillByDay(query);
        return buildResponse(modelAndView,query);
    }

    //财务日统计查询
    @RequestMapping(value = "/countMoneyForDay",method = RequestMethod.POST)
    @Pass
    public ModelAndView countMoneyForDay(@ModelAttribute AgentQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //开始时间
        Date startTime = query.getStartTime();
        if(startTime == null ){
            return buildErrorResponse(modelAndView,"开始时间不能为空！");
        }
        //截止日期
        Date endTime = query.getEndTime();
        if(endTime == null ){
            return buildErrorResponse(modelAndView,"截止时间不能为空！");
        }
        //这里的城市ID就是APPId
        String appId = query.getCityId();
        if(appId==null || appId.length()==0){
            return buildErrorResponse(modelAndView,"城市不能为空！");
        }
        Agent agent = agentService.countMoneyForDay(query);
        return buildResponse(modelAndView,agent);
    }
    /**
     * 统计年度或者月度
     * 某个县区的应审和已审车辆
     * @param cityId
     * @param xianquId
     * @param searchType
     * @param searchTime
     * @param trainType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sumXianQuLession",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumXianQuLession(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime,
            String trainType
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        int count = 0;
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = agentService.sumXianQuLessionYear(cityId,xianquId,year,trainType);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumXianQuLessionMonth(cityId,xianquId,searchTime,trainType);
        }else if(searchType.equals("DAY")){
            count = agentService.sumXianQuLessionDay(cityId,xianquId,searchTime,trainType);
        }

        return buildResponse(modelAndView,count);
    }

    /**
     * 统计年度或者月度
     * 某个县区的应审和已审车辆
     * @param cityId
     * @param xianquId
     * @param searchType
     * @param searchTime
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sumPrestoredLession",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumPrestoredLession(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        int count = 0;
        if(searchType.equals("YEAR")){
            count = agentService.sumPrestoredLessionYear(cityId,xianquId,searchTime);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumPrestoredLessionMonth(cityId,xianquId,searchTime);
        }else if(searchType.equals("DAY")){
            count = agentService.sumPrestoredLessionDay(cityId,xianquId,searchTime);
        }

        return buildResponse(modelAndView,count);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //统计电脑的学习课时
     * @Date 2019/1/29 11:20
     * @Param [cityId, xianquId, searchType, searchTime, placeType]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/sumXianQuLessionForPc",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumXianQuLessionForPc(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime,
            String placeType
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        int count = 0;
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = agentService.sumXianQuLessionForPcYear(cityId,xianquId,year,placeType);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumXianQuLessionForPcMonth(cityId,xianquId,searchTime,placeType);
        }else if(searchType.equals("DAY")){
            count = agentService.sumXianQuLessionForPcDay(cityId,xianquId,searchTime,placeType);
        }

        return buildResponse(modelAndView,count);
    }




    /**
     * @Author ZhaoSiDa
     * @Description //统计学习的人数
     * @Date 2019/1/11 8:59
     * @Param [cityId, xianquId, searchType, searchTime, trainType]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/sumXianQuPerson",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumXianQuPerson(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        int count = 0;
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = agentService.sumXianQuPersonYear(cityId,xianquId,year);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumXianQuPersonMonth(cityId,xianquId,searchTime);
        }else if(searchType.equals("DAY")){
            count = agentService.sumXianQuPersonDay(cityId,xianquId,searchTime);
        }

        return buildResponse(modelAndView,count);
    }


    /**
     * @Author ZhaoSiDa
     * @Description //统计充值的金额
     * @Date 2019/1/11 8:59
     * @Param [cityId, xianquId, searchType, searchTime, trainType]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/sumXianQurechargeMoney",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumXianQurechargeMoney(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        BigDecimal count = new BigDecimal("0.00");
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = agentService.sumXianQurechargeMoneyYear(cityId,xianquId,year);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumXianQurechargeMoneyMonth(cityId,xianquId,searchTime);
        }else if(searchType.equals("DAY")){
            count = agentService.sumXianQurechargeMoneyDay(cityId,xianquId,searchTime);
        }

        return buildResponse(modelAndView,count);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //统计消费金额
     * @Date 2019/1/11 8:59
     * @Param [cityId, xianquId, searchType, searchTime, trainType]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/sumXianQureconsumeMoney",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumXianQureconsumeMoney(
            String cityId,
            String xianquId,
            String searchType,
            Date searchTime
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH
        BigDecimal count = new BigDecimal("0.00");
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = agentService.sumXianQureconsumeMoneyYear(cityId,xianquId,year);
        }else if(searchType.equals("MONTH")){
            count = agentService.sumXianQureconsumeMoneyMonth(cityId,xianquId,searchTime);
        }else if(searchType.equals("DAY")){
            count = agentService.sumXianQureconsumeMoneyDay(cityId,xianquId,searchTime);
        }

        return buildResponse(modelAndView,count);
    }




}
