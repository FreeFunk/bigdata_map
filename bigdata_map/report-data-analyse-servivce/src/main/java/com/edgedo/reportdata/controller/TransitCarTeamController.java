package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.StringTool;
import com.edgedo.reportdata.entity.TeamReceive;
import com.edgedo.reportdata.entity.TransitCarTeam;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import com.edgedo.reportdata.service.TransitCarTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zcc
 * @description 企业信息
 * @date 2019/4/3
 */
@Controller
@ResponseBody
@RequestMapping("/sys/carTeam")
public class TransitCarTeamController extends BaseController{
    @Autowired
    private TransitCarTeamService transitCarTeamService;

    @RequestMapping("/selectCountCarTeamInfo")
    @Pass
    public ModelAndView countCarTeamByQuery(@ModelAttribute TransitCarTeamQuery query) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        int countCarTeam = transitCarTeamService.selectCountCarTeam(query);
        buildResponse(modelAndView,countCarTeam);
        return modelAndView;
    }

    //查询企业信息
    @RequestMapping("/selectTransitCarTeamInfo")
    @Pass
    public ModelAndView selectTransitCarTeamInfo(@ModelAttribute TransitCarTeamQuery query) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(query.getPage() == null){
            query.setLimit(13);
            query.setPage(1);
        }else{
            query.setLimit(13);
        }
        List<TransitCarTeam> transitCarTeamList = transitCarTeamService.selectCarTeamInfoListPage(query);
        int page = query.getPage();
        if(page==1 && query.getTeamId()==null && query.getTeamName()==null){
            TransitCarTeamQuery transitCarTeamQuery = new TransitCarTeamQuery();
            transitCarTeamQuery.setCityId("130300");
            transitCarTeamQuery.setTeamName("世伏物流");
            List<TransitCarTeam> transitCarTeamList1 = transitCarTeamService.selectCarTeamInfoListPage(transitCarTeamQuery);
            transitCarTeamList.set(0,transitCarTeamList1.get(0));
        }
        for(TransitCarTeam t:transitCarTeamList){
            t.setTeamAdminPhone(StringTool.encodeImportentNum(t.getTeamAdminPhone()));
            t.setJyCertNumber(StringTool.encodeImportentNum(t.getJyCertNumber()));
            t.setLegalRepresentLicenceType(StringTool.encodeImportentNum(t.getLegalRepresentLicenceType()));
            t.setJyChargeManPhone(StringTool.encodeImportentNum(t.getJyChargeManPhone()));
            t.setBusinessCertCode(StringTool.encodeImportentNum(t.getBusinessCertCode()));
        }
        query.setList(transitCarTeamList);
        buildResponse(modelAndView,query);
        return modelAndView;
    }

    //查询企业信息
    @RequestMapping("/selectTeamCarInfo")
    @Pass
    public ModelAndView selectTeamCarInfo(@ModelAttribute TransitCarTeamQuery query) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<TransitCarTeam> transitCarTeamList = transitCarTeamService.selectCarTeamInfo(query);
        query.setList(transitCarTeamList);
        buildResponse(modelAndView,query);
        return modelAndView;
    }


    //查询企业的整改记录
    @RequestMapping("/selectRectificationRec")
    @Pass
    public ModelAndView selectRectificationRec(@ModelAttribute TransitCarTeamQuery query)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<TeamReceive> teamReceiveList = transitCarTeamService.selectRectificationRecByTeamId(query);
        buildResponse(modelAndView,teamReceiveList);
        return modelAndView;
    }

    //查询企业的详细整改记录
    @RequestMapping("/selectRectificationRecDetail")
    @Pass
    public ModelAndView selectRectificationRecDetail(@ModelAttribute TeamReceive teamReceive)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("cityId",teamReceive.getCityId());
        paramMap.put("id",teamReceive.getId());
        TeamReceive teamReceiveObj = transitCarTeamService.selectTeamReceiveInfoById(paramMap);
        buildResponse(modelAndView,teamReceiveObj);
        return modelAndView;
    }
}
