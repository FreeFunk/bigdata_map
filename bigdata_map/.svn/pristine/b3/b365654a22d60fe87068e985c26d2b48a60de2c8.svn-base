package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.reportdata.entity.SafetyTrainingCarNum;
import com.edgedo.reportdata.entity.TransitCarVarify;
import com.edgedo.reportdata.queryvo.TransitCarVarifyQuery;
import com.edgedo.reportdata.service.TransitCarVarifyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 统计某个城市里
 */
@Controller
@RequestMapping("/sys/transitCarVarify")
@Api(value = "审车记录相关的请求",tags = "审车记录相关的请求")
public class TransitCarVarifyController extends BaseController {

    @Autowired
    TransitCarVarifyService carVarifyService;


    /**
     * 统计年度或者月度
     * 某个县区的应审和已审车辆
     * @param cityId
     * @param xianquId
     * @param searchType
     * @param searchTime
     * @param shType
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "汇总审车信息", notes = "汇总审车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "城市id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "xianquId", value = "县区id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "searchType", value = "搜索类型(YEAR,MONTH)", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "searchTime", value = "搜索时间", paramType = "query", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "shType", value = "是否已经审核(ALL,DONE)", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/sumCarVarifyXianqu",method = {RequestMethod.POST})
    @Pass
    public ModelAndView sumCarVarifyXianqu(
           String cityId,
           String xianquId,
           String searchType,
           Date searchTime,
           String shType//ALL:所有,DONE:已审
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //searchType 度:YEAR,月度，MONTH,日:DAY
        String doneFlag = null;
        if(shType.equals("DONE")){
            doneFlag = "1";
        }
        int count = 0;
        if(searchType.equals("YEAR")){
            Calendar cal = Calendar.getInstance();
            cal.setTime(searchTime);
            int year = cal.get(Calendar.YEAR);
            count = carVarifyService.sumCarVarifyXianquYear(cityId,xianquId,year,doneFlag);
        }else if(searchType.equals("MONTH")){
            count = carVarifyService.sumCarVarifyXianquMonth(cityId,xianquId,searchTime,doneFlag);
        }else if(searchType.equals("DAY")){
            count = carVarifyService.sumCarVarifyXianquDay(cityId,xianquId,searchTime,doneFlag);
        }

        return buildResponse(modelAndView,count);
    }


    @ApiOperation(value = "分页查询审车记录", notes = "分页查询审车记录")
    @ApiResponse(code = 200, message ="",response = TransitCarVarify.class)
    @RequestMapping(value = "/listCarVarifyPage.jsn",method = {RequestMethod.POST})
    @Pass
    public ModelAndView listCarVarifyPage(TransitCarVarifyQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        carVarifyService.listCarVarifyPage(query);
        return buildResponse(modelAndView,query);
    }




}
