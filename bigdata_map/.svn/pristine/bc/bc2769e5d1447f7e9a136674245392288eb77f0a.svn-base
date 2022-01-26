package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.service.BigdataBeidouCarMonthCheckService;
import com.edgedo.bigdata.service.BigdataBeidouCarTraceBkRecService;
import com.edgedo.bigdata.service.BigdataDriverCardRecService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.util.IocUtil;
import com.edgedo.util.ITask;
import com.edgedo.util.MultiThreadUtils;
import com.edgedo.util.ResultBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName BigdataBeidouCarMonthCheckAnalysis
 * @Description 车辆月度考核表
 * @Author 床前明月光
 * @Date 2019/8/5 9:08
 **/
@Component
public class BigdataBeidouCarMonthCheckAnalysis  implements ITask<ResultBean<String>, String> {

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void updateCarInfo() {
        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

        List<String> data = carInfoService.listAllVo();
        //点的路径
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date countDate = calendar.getTime();
        String countDateStr = sdfDateInt.format(countDate);

        // 创建多线程处理任务
        MultiThreadUtils<String> threadUtils = MultiThreadUtils.newInstance(10);
        ITask<ResultBean<String>, String> bigdataBeidouCarMonthCheckAnalysis = new BigdataBeidouCarMonthCheckAnalysis();
        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("countDateStr", countDateStr);
        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(data, params, bigdataBeidouCarMonthCheckAnalysis);
    }

    @Override
    public ResultBean execute(String e, Map<String, Object> params) {
        CarInfoService carInfoService = IocUtil.getBean(CarInfoService.class);
        BigdataBeidouCarMonthCheckService bigdataBeidouCarMonthCheckService = IocUtil.getBean(BigdataBeidouCarMonthCheckService.class);
        BigdataBeidouCarTraceBkRecService bigdataBeidouCarTraceBkRecService = IocUtil.getBean(BigdataBeidouCarTraceBkRecService.class);
        BigdataDriverCardRecService bigdataDriverCardRecService = IocUtil.getBean(BigdataDriverCardRecService.class);

        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        //查询车辆所属的运营商
        CarInfo carInfo = new CarInfo();
        carInfo.setCarPlateColour("2");
        carInfo.setCarPlateNum(e);
        carInfo = carInfoService.selectByCarPlateAndPlateColor(carInfo);
        if(carInfo!=null){
            //根据车牌号查询
            String countDateStr = (String) params.get("countDateStr");
            Integer dateInt = new Integer(countDateStr);
            Integer countMonth = dateInt/100;
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("carPlate", e);
            param.put("countMonth", countMonth);
            param.put("type","0");
            //统计这车这个月的轨迹不完整次数，和轨迹飘点次数
            int countByCarPlateNum = bigdataBeidouCarTraceBkRecService.countByCarPlateNum(param);
            BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck = new BigdataBeidouCarMonthCheck();
            bigdataBeidouCarMonthCheck.setCompId(carInfo.getComId());
            bigdataBeidouCarMonthCheck.setCompName(carInfo.getComName());
            bigdataBeidouCarMonthCheck.setCarPlateNum(carInfo.getCarPlateNum());
            bigdataBeidouCarMonthCheck.setCarFrameNum(carInfo.getCarFrameNum());
            bigdataBeidouCarMonthCheck.setCarPlateColor(carInfo.getCarPlateColour());
            bigdataBeidouCarMonthCheck.setCountDate(dateInt);
            bigdataBeidouCarMonthCheck.setCountMonth(countMonth);
            bigdataBeidouCarMonthCheck.setYearNum(countMonth/100);
            bigdataBeidouCarMonthCheck.setTraceUncompleteNum(countByCarPlateNum);

            Map<String, Object> param1 = new HashMap<String, Object>();
            param1.put("carPlate", e);
            param1.put("countMonth", countMonth);
            param1.put("type","1");
            //统计这车这个月的轨迹不完整次数，和轨迹飘点次数
            int countByCarPlateNum1 = bigdataBeidouCarTraceBkRecService.countByCarPlateNum(param1);
            bigdataBeidouCarMonthCheck.setTraceFlyNum(countByCarPlateNum1);
            //统计司机卡上传次数
            Map<String, Object> param2 = new HashMap<String, Object>();
            param2.put("carPlate", e);
            param2.put("countMonth", countMonth);
            param2.put("type","插卡");
            int countDriverCardUpNum = bigdataDriverCardRecService.countDriverCardUpNum(param2);
            bigdataBeidouCarMonthCheck.setDriverCardUpNum(countDriverCardUpNum);

            bigdataBeidouCarMonthCheckService.insertOrUpdate(bigdataBeidouCarMonthCheck);
        }
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(e.toString());
        return resultBean;
    }
}
