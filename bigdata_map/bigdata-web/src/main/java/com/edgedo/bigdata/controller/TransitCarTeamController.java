package com.edgedo.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.TeamReceive;
import com.edgedo.bigdata.queryvo.EmpQuery;
import com.edgedo.bigdata.queryvo.TransitCarTeamQuery;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Zcc
 * @description 业户信息
 * @date 2019/4/4
 */
@Controller
@ResponseBody
@RequestMapping("/admin/carTeam")
public class TransitCarTeamController extends BaseController {


    @Value("${ReportDataUrl}")
    private String ReportDataUrl;
    @Value("${ZhygUrl}")
    private String ZhygUrl;
    /**
     * @author Zcc
     * @Description 查询车队信息
     * @date 2019/4/3
     * @param
     * @return void
     */
    @RequestMapping(value = "/countTransitTeamInfoByQuery",method = RequestMethod.POST)
    public void countTransitTeamInfoByQuery(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException {
        String reportDataUrl = getReportDataUrl() + "/sys/carTeam/selectCountCarTeamInfo.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description 查询车队信息
     * @date 2019/4/3
     * @param
     * @return void
     */
    @RequestMapping(value = "/searchTransitTeamInfoByQuery",method = RequestMethod.POST)
    public void searchTransitTeamInfoByQuery(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException {
        String reportDataUrl =getReportDataUrl() + "/sys/carTeam/selectTransitCarTeamInfo.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description  根据企业id查询从业人员
     * @date 2019/4/3
     * @param
     * @return void
     */
    @RequestMapping(value = "/selectEmpListByCarTeam",method = RequestMethod.POST)
    public void selectEmpListByCarTeam(@ModelAttribute EmpQuery query) throws IllegalAccessException,IOException{
        String reportDataUrl =getReportDataUrl() + "/sys/emp/selectEmpListByCarTeam.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description  根据企业id查询整改记录
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectRectificationRec",method = RequestMethod.POST)
    public ModelAndView selectRectificationRec(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String reportDataUrl =getReportDataUrl() + "/sys/carTeam/selectRectificationRec.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        JSONObject jsonObject = (JSONObject) JSON.parse(responseStr);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        List<TeamReceive> teamReceiveList = new ArrayList<>();
        if(jsonArray.size()>0){
            for(int i=0;i<jsonArray.size();i++){
                TeamReceive teamReceive = JSONObject.toJavaObject(jsonArray.getJSONObject(i),TeamReceive.class);
                if(teamReceive != null){
                    teamReceiveList.add(teamReceive);
                }
            }
        }
        buildResponse(modelAndView,teamReceiveList);
        return modelAndView;
    }

    @RequestMapping(value = "/selectRectificationRecDetail",method = RequestMethod.POST)
    public ModelAndView selectRectificationRecDetail(@ModelAttribute TeamReceive teamReceive) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String reportDataUrl =getReportDataUrl() + "/sys/carTeam/selectRectificationRecDetail.jsn";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(teamReceive,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description  查询制度问题
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectZhiDuList",method = RequestMethod.POST)
    public ModelAndView selectZhiDuList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String zhygUrl =getZhygUrl() + "/ledgerController!listForZhiDuUndoTaskForBigdata.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description 查询企业文件未接收
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectCheckFileList",method = RequestMethod.POST)
    public ModelAndView selectCheckFileList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String zhygUrl =getZhygUrl() + "/ledgerController!listForCheckFileUndoTaskForBigData.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description  查询企业下的未上传图片的车辆
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectUnUploadPhotoCarList",method = RequestMethod.POST)
    public void selectUnUploadPhotoCarList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        String zhygUrl =getZhygUrl() + "/ledgerController!listForUnuploadPhotoForBigdata.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
    }

    /**
     * @author Zcc
     * @Description 查询台账信息的车辆
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectUnqualifiedLedgerList",method = RequestMethod.POST)
    public ModelAndView selectUnqualifiedLedgerList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String zhygUrl = getZhygUrl() + "/ledgerController!listForUnqualifiedLedgerForBigdata.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description 查询安全教育的车辆
     * @date 2019/4/4
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/selectUnUploadEduCarList",method = RequestMethod.POST)
    public ModelAndView selectUnUploadEduCarList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String zhygUrl = getZhygUrl() + "/ledgerController!listForUnuploadEduforBigdata.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description 根据车队类型查询制度
     * @date 2019/4/18
     * @param
     * @return org.springframework.web.servlet.ModelAndView
    */
    @RequestMapping(value = "/selectTeamZhiDuList",method = RequestMethod.POST)
    public ModelAndView selectTeamZhiDuList(@ModelAttribute TransitCarTeamQuery query) throws IllegalAccessException,IOException{
        ModelAndView modelAndView = new ModelAndView();
        String zhygUrl =getZhygUrl() + "/transitCarTeamController!selectTeamZhiDuList.action";
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
        outStringToBrowser(responseStr);
        return modelAndView;
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
