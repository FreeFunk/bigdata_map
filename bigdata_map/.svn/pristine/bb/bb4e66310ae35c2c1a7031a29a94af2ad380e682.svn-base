package com.edgedo.common.util;


import org.apache.commons.io.IOUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wangzhen
 */
public class FileUtil {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    //定义文件保存路径的系统配置常量
    public static final String tdp_upfile_img_save_forder_key = "tdp_upfile_img_save_forder";
    //图片的域名的系统配置常量
    public static final String tdp_img_host_key = "tdp_img_host_key";

    public static final String photoNameExt = "jpg,gif,png,jpeg";


    //头像文件的文件路径
    public static final String USER_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "userface" ;
    //学习时候的人脸文件路径
    public static final String LEARN_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "learnface" ;
    //学习答题时候的人脸文件路径
    public static final String ANSWER_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "answerface" ;
    public static final String LEARN_LIVE_PHOTO_MODEL_PATH = "upfile" + File.separator + "livelearnpic" ;
    public static final String YW_TRAINLESSION_COVERIMG_PATH = "upfile" + File.separator + "coverimg";


    /**
     *  保存文件
     */
    public static String saveFile(MultipartFile file, String fileForder, boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String oraName = file.getOriginalFilename();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = file.getInputStream();
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    public static String saveFile(byte[] fileByte,String fileForder,boolean webPathFlag,String fileExt) throws Exception {
        String uuid = Guid.guid();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new ByteArrayInputStream(fileByte);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    /**
     *  保存文件
     */
    public static String saveFile(File file,String fileForder,boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String oraName = file.getName();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(file);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    /**
     *  保存文件
     */
    public static String saveFile(byte[] fileArr,String fileForder,String oraName,boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new ByteArrayInputStream(fileArr);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }


    /**
     *  保存文件
     */
    public static void saveCopyFile(MultipartFile file, String realPath) throws Exception {
        String oraName = file.getOriginalFilename();

        File targetFile = new File(realPath);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = file.getInputStream();
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
    }

    /**
     * 是否是图片
     * @return
     */
    public static boolean isImage(MultipartFile file){
        String extend = getFileExtend(file);
        if(photoNameExt.indexOf(extend)>=0){
            return true;
        }else{
            return false;
        }

    }


    public static String getFileExtend(MultipartFile file){
        String oraName = file.getOriginalFilename();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        return fileExt;
    }

    public static String getFileExtend(String filePath){
        String fileExt = filePath.substring(filePath.lastIndexOf(".")+1).toLowerCase();
        return fileExt;
    }

    /**
     *  获得图片宽度
     * @param photo
     * @return
     * @throws Exception
     */
    public static int getPhotoWidth(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            return sourceImg.getWidth();
        } catch (IOException e) {
           throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getPhotoWidth(File photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = new FileInputStream(photo);
            sourceImg = ImageIO.read(is);
            return sourceImg.getWidth();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *  获得图片高度
     * @param photo 图片
     * @return
     * @throws Exception
     */
    public static int getPhotoHeight(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            return sourceImg.getHeight();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getPhotoHeight(File photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = new FileInputStream(photo);
            sourceImg = ImageIO.read(is);
            return sourceImg.getHeight();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  获得图片宽度高度比
     * @param photo 图片
     * @return
     * @throws Exception
     */
    public static double getPhotoWidthDeiveHeight(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            int width = sourceImg.getWidth();
            int height = sourceImg.getHeight();
            return width*1.0/(height*1.0);
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     */
    public static void deleteFile(final String path){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    String rootpath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
                    String filePath = rootpath + File.separator + path.replace("/", File.separator);
                    String fileForder = filePath.substring(0,filePath.lastIndexOf(File.separator));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
                    File forder = new File(fileForder);
                    File file = new File( forder,fileName);
                    if(file.exists()){
                        file.delete();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }

    /**
     * 根据绝对路径删除文件
     * @param filePath
     */
    public static void deleteFileByRealPath(final String filePath){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    File file = new File(filePath);
                    if(file.exists()){
                        file.delete();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }

    /**
     * 将web路径转换成文件路径
     * @param path
     * @return
     */
    public static String changeWebPathToFilePath(String path){
        String filePath = "";
        String[] strArr = path.split("/");
        for(int i=0;i<strArr.length;i++){
            if(i==strArr.length-1){
                filePath = filePath+strArr[i];
            }else{
                filePath = filePath+strArr[i]+File.separator;
            }

        }
        return filePath;
    }

   /* public static void main(String[] args){
//        String str = "/upfile/userface//2018/6/16/9a3531e4131e4437b933ead89a243c49.jpg";
//        System.out.println(changeWebPathToFilePath(str));
        String base64 = "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";
        generateImageFromBase64Str(base64,"D:\\1.jpg");
    }*/

    /**
     * 将文件路径转换成web路径
     * @param filepath
     * @return
     */
    public static String changeFilePathToWebPath(String filepath){
        String webpath = filepath.replaceAll("\\\\","\\/");

        return webpath;
    }

    /**
     * 获取图片的base64编码
     * @param tdp_upfile_forder
     * @param webPath
     */
    public static String getImgFileBase64String(String tdp_upfile_forder, String webPath) {
        String filePath =  changeWebPathToFilePath(webPath);
        String targetFile = tdp_upfile_forder + filePath;
        System.out.println("转图片的路径;" + targetFile);
        File file = new File(targetFile);
        if(file.exists()){
            return getImageBase64Str(file);
        }else{
            return "";
        }

    }

    /**
     * 图片转化成base64字符串
     * @param target
     * @return
     */
    public static String getImageBase64Str(File target){
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(target);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    /**
     * 图片转化成base64字符串
     * @param buffer 图片字节数组
     * @return
     */
    public static String getImageBase64Str(byte[] buffer){
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(buffer);//返回Base64编码过的字节数组字符串
    }

    /**
     *   base64字符串转化成图片保存到本地
     */
    public static boolean generateImageFromBase64Str(String base64Str,String targetFileName)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try{
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64Str);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            File targetFile = new File(targetFileName);
            File forder = targetFile.getParentFile();
            if(!forder.exists()){
                forder.mkdirs();
            }
            if(!targetFile.exists()){
                forder.createNewFile();
            }
            //生成jpeg图片
            out = new FileOutputStream(targetFile);
            out.write(b);
            out.flush();

            return true;
        }catch (Exception e) {
            return false;
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *   base64字符串转化成图片保存到本地
     */
    public static byte[] generateImageFromBase64Str(String base64Str)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return new byte[0];
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try{
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64Str);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
           return b;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 将文件读取成字节数组
     * @param file
     * @return
     */
    public static byte[] getFileByteArr(File file) throws  Exception {
        InputStream is = new FileInputStream(file);
        int length = is.available();
        byte[] byteArr = new byte[length];
        is.read(byteArr);
        return byteArr;
    }


}
