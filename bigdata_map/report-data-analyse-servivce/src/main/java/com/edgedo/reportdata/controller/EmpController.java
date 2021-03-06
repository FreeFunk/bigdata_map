package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.StringTool;
import com.edgedo.reportdata.entity.Emp;
import com.edgedo.reportdata.entity.SafetyTrainingRecEmp;
import com.edgedo.reportdata.queryvo.EmpQuery;
import com.edgedo.reportdata.service.EmpService;
import jodd.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/sys/emp")
public class EmpController extends BaseController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/countEmpByQuery")
    @Pass
    @ResponseBody
    public ModelAndView countEmpByQuery(@ModelAttribute EmpQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        int countEmpByQuery = empService.countEmpByQuery(query);
        buildResponse(modelAndView,countEmpByQuery);
        return modelAndView;
    }
    //查询从业人人员的列表
    @RequestMapping("/selectEmpByQuery")
    @Pass
    @ResponseBody
    public ModelAndView selectEmpByQuery(@ModelAttribute EmpQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Emp> empList = empService.selectEmpByQueryListPage(query);
        for (Emp emp:empList) {
            String thirdId = emp.getId();
            Map<String,Object> param = new HashMap<>();
            param.put("cityId","130300");
            param.put("thirdId",thirdId);
            String headPhoto = empService.selectHeadPhoto(param);
            if(headPhoto != null){
                String headPhotoNew = "https://trainimg.qhd12328.com/130300"+headPhoto;
                emp.setHeadPhoto(headPhotoNew);
            }
            emp.setLicenceCode(StringTool.encodeImportentNum(emp.getLicenceCode()));
            emp.setEmpPhone(StringTool.encodeImportentNum(emp.getEmpPhone()));
            emp.setEmpIdCard(StringTool.encodeImportentNum(emp.getEmpIdCard()));
        }
        query.setList(empList);
        buildResponse(modelAndView,query);
        return modelAndView;
    }

    //查询从业人人员的列表
    @RequestMapping("/listPageEmpByQuery")
    @Pass
    @ResponseBody
    public ModelAndView listPageEmpByQuery(@ModelAttribute EmpQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(query.getPage() == null){
            query.setLimit(13);
            query.setPage(1);
        }
        List<Emp> empList = empService.listPageEmpByQuery(query);
        int page = query.getPage();
   /*     if(page == 1){
            EmpQuery  empQuery = new EmpQuery();
            empQuery.setId("732d628776374678a16704cace348ae3");
            List<Emp> empList1 = empService.listPageEmpByQuery(empQuery);
            empList.set(0,empList1.get(0));
        }*/
        for(Emp e:empList){
            e.setEmpPhone(StringTool.encodeImportentNum(e.getEmpPhone()));
            e.setLicenceCode(StringTool.encodeImportentNum(e.getLicenceCode()));
        }
        query.setList(empList);
        buildResponse(modelAndView,query);
        return modelAndView;
    }

    //给从业人员发送站内信消息，并且
    @RequestMapping("/sendLessionToEmp")
    @Pass
    @ResponseBody
    public ModelAndView sendLessionToEmp(
        HttpServletRequest request
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String cityId = request.getParameter("cityId");
        String empId = request.getParameter("empId");
        String siteMsg = request.getParameter("siteMsg");
        String isFatigued = request.getParameter("isFatigued");
        String fatiguedNumSum = request.getParameter("fatiguedNumSum");
        String seriousFatiguedNumSum = request.getParameter("seriousFatiguedNumSum");
        String isOverSpeed = request.getParameter("isOverSpeed");
        String overSpeedNumSum = request.getParameter("overSpeedNumSum");
        String seriousOverSpeedNumSum = request.getParameter("seriousOverSpeedNumSum");
        String countMonth = request.getParameter("countMonth");
        empService.updateSendLessionToEmp(cityId,
                empId,siteMsg,isFatigued,fatiguedNumSum,seriousFatiguedNumSum,
                isOverSpeed,overSpeedNumSum,seriousOverSpeedNumSum,countMonth);
        buildResponse(modelAndView);
        return modelAndView;
    }


    //查询从业人人员的详情
    @RequestMapping("/selectEmpDetail")
    @Pass
    public ModelAndView selectEmpDetail(@ModelAttribute EmpQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Emp emp = empService.selectEmpDetail(query);
        buildResponse(modelAndView,emp);
        return modelAndView;
    }

    //查询从业人人员的学习记录
    @RequestMapping("/selectEmpSafetyRec")
    @Pass
    public ModelAndView selectEmpSafetyRec(@ModelAttribute EmpQuery query) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SafetyTrainingRecEmp> safetyTrainingRecEmpList = empService.selectEmpSafetyRec(query);
        buildResponse(modelAndView,safetyTrainingRecEmpList);
        return modelAndView;
    }

    /**
     * @author Zcc
     * @Description  根据从业人员查询相关车辆
     * @date 2019/4/13
     * @param
     * @return org.springframework.web.servlet.ModelAndView
    */
    @RequestMapping("/selectCarByEmpInfo")
    @Pass
    public ModelAndView selectCarByEmpInfo(@ModelAttribute EmpQuery empQuery) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }


    /**
     * @author Zcc
     * @Description 根据车辆信息查询从业人员
     * @date 2019/4/3
     * @param
     * @return org.springframework.web.servlet.ModelAndView
    */
    @RequestMapping("/listPageEmpByCarInfo")
    @Pass
    public ModelAndView listPageEmpByCarInfo(@ModelAttribute EmpQuery query) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Emp> empList = empService.selectEmpByCarInfo(query);
        buildResponse(modelAndView,empList);
        return modelAndView;
    }

    @RequestMapping(value = "/selectEmpListByCarTeam",method = RequestMethod.POST)
    @Pass
    public ModelAndView selectEmpListByCarTeam(@ModelAttribute EmpQuery query) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Map<String,String> parameterMap = new HashMap<>();
        parameterMap.put("ownerCarTeamId",query.getOwnerCarTeamId());
        parameterMap.put("cityId",query.getCityId());
        List<Emp> empList = empService.selectEmpListByCarTeam(parameterMap);
        buildResponse(modelAndView,empList);
        return modelAndView;
    }

    //按id默认排序查询从业人员
    @RequestMapping("/selectEmpByStartAndLimit")
    @Pass
    @ResponseBody
    public ModelAndView selectEmpByStartAndLimit(String cityId,Integer start,Integer limit) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("start",start);
        param.put("limit",limit);
        List<Emp> empList = empService.selectEmpByStartAndLimit(param);

        buildResponse(modelAndView,empList);
        return modelAndView;
    }

}
