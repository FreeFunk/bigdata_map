package com.edgedo.reportdata.controller;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.reportdata.entity.Emp;
import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.queryvo.EmpQuery;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import com.edgedo.reportdata.service.EmpService;
import com.edgedo.reportdata.service.TransitCarInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/transitCarBaseinfo")
public class TransitCarBaseinfoController extends BaseController {

    @Autowired
    private TransitCarInfoService transitCarInfoService;
    @Autowired
    private EmpService empService;


    @RequestMapping("/countCarinfoByQuery")
    @Pass
    public ModelAndView countCarinfoByQuery(@ModelAttribute TransitCarInfoQuery query){
        ModelAndView modelAndView = new ModelAndView();
        int countCarinfoByQuery = transitCarInfoService.countCarinfoByQuuery(query);
        buildResponse(modelAndView,countCarinfoByQuery);
        return modelAndView;
    }


    @RequestMapping("/carBaseinfoListByQuery")
    @Pass
    public ModelAndView carBaseinfoListPage(@ModelAttribute TransitCarInfoQuery carInfoQuery){
        ModelAndView modelAndView = new ModelAndView();
        if(carInfoQuery.getPage() == null){
            carInfoQuery.setLimit(13);
            carInfoQuery.setPage(1);
        }else{
            carInfoQuery.setLimit(13);
        }
        List<TransitCarBaseinfo> transitCarBaseinfoList = transitCarInfoService.selectCarBaseinfoListPage(carInfoQuery);
      /*  int page = carInfoQuery.getPage();
        if(page==1 && carInfoQuery.getId()==null && carInfoQuery.getCarPlateNum()==null && carInfoQuery.getCarFrameNum()==null ){
            TransitCarInfoQuery transitCarInfoQuery = new TransitCarInfoQuery();
            transitCarInfoQuery.setCarPlateNum("???CD1176");
            List<TransitCarBaseinfo> transitCarBaseinfoList1 = transitCarInfoService.selectCarBaseinfoListPage(transitCarInfoQuery);
            transitCarBaseinfoList.set(0,transitCarBaseinfoList1.get(0));
        }*/
        carInfoQuery.setList(transitCarBaseinfoList);
        buildResponse(modelAndView,carInfoQuery);
        return modelAndView;
    }

    @RequestMapping("/selectCarByCarTeam")
    @Pass
    public ModelAndView selectCarListByCarTeam(@ModelAttribute TransitCarInfoQuery query){
        ModelAndView modelAndView = new ModelAndView();
        Map<String,String> parameterMap = new HashMap<>();
        parameterMap.put("ownerTeamId",query.getOwnerTeamId());
        parameterMap.put("cityId",query.getCityId());
        List<TransitCarBaseinfo> baseinfoList = transitCarInfoService.selectCarListByCarTeam(parameterMap);
        buildResponse(modelAndView,baseinfoList);
        return modelAndView;
    }

    /**
     * ?????????????????????????????????
     * ??????????????????
     * @return
     */
    @RequestMapping("/bigDataSearchCarPlate")
    @Pass
    public ModelAndView bigDataSearchCarPlate(TransitCarInfoQuery query){
        String carPlateColor = query.getCarPlateColor();
        ModelAndView modelAndView = new ModelAndView();
        List<TransitCarBaseinfo> carList = transitCarInfoService.selectByCarPlateNum(query);
        TransitCarBaseinfo resCar = null;
        if(carList.size()==1){
            resCar = carList.get(0);
        }else{
            for(TransitCarBaseinfo carBaseinfo : carList){
                String color = carBaseinfo.getCarPlateColor();
                if(color.equals(carPlateColor)){
                    resCar = carBaseinfo;
                    break;
                }
            }
            if(resCar==null && carList.size()>1){
                resCar = carList.get(0);
            }
        }
        if(resCar==null){
            return buildErrorResponse(modelAndView,"???????????????");
        }
        buildResponse(modelAndView,resCar);
        return modelAndView;
    }


    @RequestMapping("/selectCarInfoByQuery")
    @Pass
    public ModelAndView selectCarInfoByQuery(@ModelAttribute TransitCarInfoQuery carInfoQuery){
        ModelAndView modelAndView = new ModelAndView();
        TransitCarBaseinfo transitCarBaseinfo = transitCarInfoService.selectCarInfoByQuery(carInfoQuery);
        if(transitCarBaseinfo!=null){
            EmpQuery empQuery = new EmpQuery();
            //?????????carPlateNum??????carId
            empQuery.setCarPlateNum(transitCarBaseinfo.getId());
            Emp emp = empService.selectEmpByCarInfoNew(empQuery);
            if(emp!=null){
                transitCarBaseinfo.setEmpId(emp.getId());
                transitCarBaseinfo.setEmpName(emp.getEmpName());
                transitCarBaseinfo.setEmpCode(emp.getLicenceCode());
                transitCarBaseinfo.setEmpPhone(emp.getEmpPhone());
            }
        }
        buildResponse(modelAndView,transitCarBaseinfo);
        return modelAndView;
    }

    @RequestMapping("/selectCarInfoByQueryNew")
    @Pass
    public ModelAndView selectCarInfoByQueryNew(@ModelAttribute TransitCarInfoQuery carInfoQuery){
        ModelAndView modelAndView = new ModelAndView();
        TransitCarBaseinfo transitCarBaseinfo = transitCarInfoService.selectCarInfoByQueryNew(carInfoQuery);
        if(transitCarBaseinfo!=null){
            EmpQuery empQuery = new EmpQuery();
            //?????????carPlateNum??????carId
            empQuery.setCarPlateNum(transitCarBaseinfo.getId());
            Emp emp = empService.selectEmpByCarInfoNew(empQuery);
            if(emp!=null){
                transitCarBaseinfo.setEmpId(emp.getId());
                transitCarBaseinfo.setEmpName(emp.getEmpName());
                transitCarBaseinfo.setEmpCode(emp.getLicenceCode());
                transitCarBaseinfo.setEmpPhone(emp.getEmpPhone());
            }
        }
        buildResponse(modelAndView,transitCarBaseinfo);
        return modelAndView;
    }


}
