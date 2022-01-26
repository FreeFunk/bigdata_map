package com.edgedo.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.TeamReceive;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.EmpQuery;
import com.edgedo.bigdata.queryvo.TransitCarTeamQuery;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.BusinessException;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/bigdatadata")
@ResponseBody
public class BigDataController extends BaseController {

    @Value("${ReportDataUrl}")
    private String ReportDataUrl;
    @Value("${ZhygUrl}")
    private String ZhygUrl;

    /**
     * @Author ZhaoSiDa
     * @Description //统计从业人员的数量
     * @Date 2019/3/28 18:04
     * @Param [query]
     * @return void
     **/
    @RequestMapping(value = "/countEmpByQuery",method = RequestMethod.POST)
    public void countEmpByQuery(@ModelAttribute EmpQuery query) throws IllegalAccessException, IOException {
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl()+"/sys/emp/countEmpByQuery.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }
    /**
     * @Author ZhaoSiDa
     * @Description //查询从业人员的列表
     * @Date 2019/4/1 14:11
     * @Param [query]
     * @return void
     **/
    @RequestMapping(value = "/selectEmpByQuery",method = RequestMethod.POST)
    public void selectEmpByQuery(@ModelAttribute EmpQuery query) throws IllegalAccessException, IOException {
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl()+"/sys/emp/selectEmpByQuery.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //分页查询从业人员的列表
     * @Date 2019/4/1 14:11
     * @Param [query]
     * @return void
     **/
    @RequestMapping(value = "/listPageEmpByQuery",method = RequestMethod.POST)
    public void listPageEmpByQuery(@ModelAttribute EmpQuery query) throws IllegalAccessException, IOException {
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl()+"/sys/emp/listPageEmpByQuery.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //查询从业人员的详情
     * @Date 2019/4/1 14:11
     * @Param [query]
     * @return void
     **/
    @RequestMapping(value = "/selectEmpDetail",method = RequestMethod.POST)
    public void selectEmpDetail(@ModelAttribute EmpQuery query) throws IllegalAccessException, IOException {
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl()+"/sys/emp/selectEmpDetail.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //查询从业人员的安全学习记录
     * @Date 2019/4/2 10:49
     * @Param [query]
     * @return void
     **/
    @RequestMapping(value = "/selectEmpSafetyRec",method = RequestMethod.POST)
    public void selectEmpSafetyRec(@ModelAttribute EmpQuery query) throws IllegalAccessException, IOException {
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl()+"/sys/emp/selectEmpSafetyRec.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description 根据从业人员查询相关联的车辆
     * @date 2019/4/13
     * @param
     * @return void
    */
    @RequestMapping(value = "/selectCarByEmpInfo",method = RequestMethod.POST)
    public void selectCarByEmpInfo(@ModelAttribute EmpQuery empQuery) throws  IllegalAccessException,IOException{
        String reportDataUrl = getReportDataUrl()+"/sys/emp/selectCarByEmpInfo.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(empQuery,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }



    /**
     * @author Zcc
     * @Description 查询车辆信息
     * @date 2019/4/3
     * @param
     * @return void
    */
    @RequestMapping(value = "/countCarInfoByQuery",method = RequestMethod.POST)
    public void countCarInfoByQuery(@ModelAttribute CarInfoQuery query) throws IllegalAccessException,IOException{
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl() + "/sys/transitCarBaseinfo/countCarinfoByQuery.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description 查询车辆信息
     * @date 2019/4/3
     * @param
     * @return void
     */
    @RequestMapping(value = "/selectCarInfoByQuery",method = RequestMethod.POST)
    public void selectCarInfoByQuery(@ModelAttribute CarInfoQuery query) throws IllegalAccessException,IOException{
        //获取数据服务的url
        String reportDataUrl = getReportDataUrl() + "/sys/transitCarBaseinfo/carBaseinfoListByQuery.jsn";
        Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description  查询车队的数量
     * @date 2019/4/3
     * @param
     * @return void
    */
    @RequestMapping(value = "/countTransitTeamByQuery",method = RequestMethod.POST)
    public void searchTransitTeamInfo(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        String reportDataUrl = getReportDataUrl() + "/sys/carTeam/selectCountCarTeamInfo.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        outStringToBrowser(responseStr);
    }

    public String getReportDataUrl() {
        return ReportDataUrl;
    }

    public void setReportDataUrl(String reportDataUrl) {
        ReportDataUrl = reportDataUrl;
    }

    public String getZhygUrl() {
        return ZhygUrl;
    }

    public void setZhygUrl(String zhygUrl) {
        ZhygUrl = zhygUrl;
    }
}

