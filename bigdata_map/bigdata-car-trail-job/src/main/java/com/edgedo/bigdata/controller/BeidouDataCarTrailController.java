package com.edgedo.bigdata.controller;



import com.edgedo.common.base.BaseController;
import jodd.io.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
@RequestMapping("/cartrail")
public class BeidouDataCarTrailController extends BaseController{

    @Value("${cartrail.forder}")
    private String cartrailForder;

    /**
     *
     * @param carPlate
     * @param searchDay 20190516.log
     * @param response
     */
    @RequestMapping(value = "/loadCarTrail")
    public void loadCarTrail(
            String carPlate, String searchDay,
            HttpServletResponse response){
        try {
            searchDay = searchDay.replaceAll("-","");
            OutputStream os = response.getOutputStream();
//            String path = new String("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log".getBytes(), "GBK");
//            File file = new File("/server/vdb1/gpsdata/remoteFile/182.92.67.1/鲁UM6897/20190423.log");
//            System.out.println(file.exists());
            File dataForder = new File(cartrailForder);
            File trailFile = new File(dataForder,
                    new String(carPlate.getBytes(),"GBK") +
                            File.separator +
                            searchDay +".log");
            System.out.println("======" + trailFile.getAbsolutePath() +"|"+trailFile.exists());
            if(trailFile.exists()){
                FileInputStream fis = null;
                BufferedReader br = null;
                try {
                    fis = new FileInputStream(trailFile);
                    byte[] buf = new byte[4096];
                    int length = 0;
                    while ((length = fis.read(buf)) > 0) {
                        os.write(buf, 0, length);
                    }
                    return;
                }catch (Exception e){
                }finally {
                    if(fis!=null){
                        fis.close();
                    }
                }
            }
            os.write("".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


	
}
