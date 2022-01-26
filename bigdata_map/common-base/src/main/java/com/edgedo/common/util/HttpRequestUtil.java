package com.edgedo.common.util;


import com.edgedo.common.base.BusinessException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * http工具类
 */
public class HttpRequestUtil {


    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){
                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                       /* if (hostname.equals("localhost")) {
                            return true;
                        }else  if (hostname.equals("118.85.194.45")) {
                            return true;
                        }*/
                        return true;
                    }
                });
    }


    /**
     * 发送携带参数的post请求
     * @param url 请求地址
     * @param params 请求参数
     * @param accessToken 前台的token
     * @return
     */
    public static String sendPostRequest(String url,Map<String,String> params,String accessToken) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setRequestProperty("Content-type", "text/html");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        connection.setRequestProperty("access-token", accessToken);
//        connection.setRequestProperty("Cookie", cookies);
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");

        // Post 请求不能使用缓存
        connection.setUseCaches(false);

        connection.setInstanceFollowRedirects(true);

        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        String content = "";
        for(Map.Entry<String,String> entry : params.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(content.length()==0){
                content += (key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }else{
                content +=( "&"+key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }
        }
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        out.flush();
        out.close();

        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder sb = new StringBuilder("");
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        inputStream.close();
        reader.close();
        connection.disconnect();

        return sb.toString();
    }


    public static String sendGetRequest(String url) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setRequestProperty("Content-type", "text/html");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
//        connection.setRequestProperty("Cookie", cookies);
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("GET");

        // Post 请求不能使用缓存
        connection.setUseCaches(false);

        connection.setInstanceFollowRedirects(true);

        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes("");
        out.flush();
        out.close();

        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder sb = new StringBuilder("");
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        inputStream.close();
        reader.close();
        connection.disconnect();

        return sb.toString();
    }


    /**
     * 发送携带参数的post请求
     * @param url 请求地址
     * @return
     */
    public static String sendPostRequest(String url,Map<String,String> params,Map<String,String> header) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setRequestProperty("Content-type", "text/html");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        Set<String> keySet = header.keySet();
        for(String key : keySet){
            connection.setRequestProperty(key, header.get(key));
        }
//        connection.setRequestProperty("Cookie", cookies);
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");

        // Post 请求不能使用缓存
        connection.setUseCaches(false);

        connection.setInstanceFollowRedirects(true);

        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        String content = "";
        for(Map.Entry<String,String> entry : params.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(content.length()==0){
                content += (key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }else{
                content +=( "&"+key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }
        }
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        out.flush();
        out.close();

        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder sb = new StringBuilder("");
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        inputStream.close();
        reader.close();
        connection.disconnect();

        return sb.toString();
    }

    /**
     *  用流来接收返回数据
     * @param url 请求地址
     * @return
     */
    public static Map<String,String> sendPostRequestStream(String url,Map<String,String> params,Map<String,String> header,OutputStream temOs) throws IOException {
        Map<String,String> result = new HashMap<String,String>();
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setRequestProperty("Content-type", "text/html");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        Set<String> keySet = header.keySet();
        for(String key : keySet){
            connection.setRequestProperty(key, header.get(key));
        }
//        connection.setRequestProperty("Cookie", cookies);
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
//        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");

        // Post 请求不能使用缓存
        connection.setUseCaches(false);

        connection.setInstanceFollowRedirects(true);

        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        String content = "";
        for(Map.Entry<String,String> entry : params.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(content.length()==0){
                content += (key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }else{
                content +=( "&"+key + "=" +  URLEncoder.encode(value, "UTF-8"));
            }
        }
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        out.flush();
        out.close();
        if(temOs!=null){
            InputStream inputStream = connection.getInputStream();
            byte[] buf = new byte[4096];
            int length = 0;
            while ((length = inputStream.read(buf)) > 0){
                temOs.write(buf,0,length);
            }
            temOs.close();
            inputStream.close();
        }

        int code = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK) {
            String cookieskey = "Set-Cookie";
            Map<String, List<String>> maps = connection.getHeaderFields();
            List<String> coolist = maps.get(cookieskey);
            if (coolist != null ) {
                Iterator<String> it = coolist.iterator();
                StringBuffer sbu = new StringBuffer();
                while(it.hasNext()){
                    sbu.append(it.next());
                    result.put("cookies",sbu.toString().replaceAll(" path=/; HttpOnly","")+" admin=QHD");
                }
            }
        }//if
        connection.disconnect();
        return result;
    }





    /**
     * 发送携带参数的post请求
     * @param url 请求地址
     * @return
     */
    public static String sendPostRequest(String url,Map<String,String> params)  {
        try {
            // Post请求的url，与get不同的是不需要带参数
            URL postUrl = new URL(url);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setRequestProperty("Content-type", "text/html");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            // 设置是否向connection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true
            connection.setDoOutput(true);
            // Read from the connection. Default is true.
            connection.setDoInput(true);
            // 默认是 GET方式
            connection.setRequestMethod("POST");

            // Post 请求不能使用缓存
            connection.setUseCaches(false);

            connection.setInstanceFollowRedirects(true);

            // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
            // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
            // 进行编码
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
            // 要注意的是connection.getOutputStream会隐含的进行connect。
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            // The URL-encoded contend
            // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
            String content = "";
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (content.length() == 0) {
                    content += (key + "=" + URLEncoder.encode(value, "UTF-8"));
                } else {
                    content += ("&" + key + "=" + URLEncoder.encode(value, "UTF-8"));
                }
            }
            // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
            out.writeBytes(content);
            out.flush();
            out.close();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder sb = new StringBuilder("");
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            inputStream.close();
            reader.close();
            connection.disconnect();

            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("请求失败post fail");
        }
    }

    /**
     * 发送携带参数的post请求
     * @return
     */
    public static HttpResuestResponseStreamWrap postRequestByte(String urlStr, Map<String,Object> param){
        String paramStr = formatParam(param);
        // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConn = null;
        try{
            URL url = new URL(urlStr);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // ��������ʽ��GET/POST��
            httpUrlConn.setRequestMethod("POST");

            outputStream = httpUrlConn.getOutputStream();
            // ע������ʽ����ֹ��������
            outputStream.write(paramStr.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();

            // �����ص�������ת�����ַ���
            inputStream = httpUrlConn.getInputStream();
            // �ͷ���Դ
             return new HttpResuestResponseStreamWrap(inputStream,httpUrlConn,outputStream);

        }catch(Exception e){
            e.printStackTrace();
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(httpUrlConn!=null){
                httpUrlConn.disconnect();
            }
        }
        return null;
    }


    /**
     * 发送携带参数的post请求
     * @return
     */
    public static String postRequest(String urlStr, Map<String,Object> param){
        String paramStr = formatParam(param);
        StringBuffer buffer = new StringBuffer();
        // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpURLConnection httpUrlConn = null;
        try{
            URL url = new URL(urlStr);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // ��������ʽ��GET/POST��
            httpUrlConn.setRequestMethod("POST");

            outputStream = httpUrlConn.getOutputStream();
            // ע������ʽ����ֹ��������
            outputStream.write(paramStr.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();

            // �����ص�������ת�����ַ���
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // �ͷ���Դ
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
            httpUrlConn.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //�ر���
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(httpUrlConn != null){
                httpUrlConn.disconnect();
            }
        }
        return buffer.toString();
    }

    public static String formatParam(Map<String,Object> param){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Object> entry : param.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            if(value==null){
                continue;
            }
            if(value instanceof Date){
                Date temDate = (Date)value;
                String valueStr = sdf.format(temDate);
                try {
                    sb.append((sb.length()>0?"&":"")+key+"=").append(URLEncoder.encode(valueStr,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    sb.append((sb.length()>0?"&":"")+key+"=").append(URLEncoder.encode(value.toString(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }



    /**
     * 发送表单请求
     * @param urlStr
     * @param params
     * @return
     */
    public static String sendPostGbk(String urlStr, Map<String, String> params,Map<String,String> header){
        int i = 0;
        StringBuffer sb = new StringBuffer("");
        URL url;
        try {
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "text/html");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            if(header!=null){
                Set<String> keySet = header.keySet();
                for(String key:keySet){
                    connection.setRequestProperty(key, header.get(key));
                }
            }

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
//            connection.setDoInput(true);
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            String content = "";
            for(Map.Entry<String,String> entry : params.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                if(content.length()==0){
                    content += (key + "=" +  URLEncoder.encode(value, "UTF-8"));
                }else{
                    content +=( "&"+key + "=" +  URLEncoder.encode(value, "UTF-8"));
                }
            }
            // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
            out.writeBytes(content);
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "gbk"));
            String s = "";
            while ((s = br.readLine()) != null) {
                i++;
                sb.append(s + "\r\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return sb.toString();

    }



    public static class HttpResuestResponseStreamWrap{
        private InputStream inputStream =null;
        private HttpURLConnection httpUrlConn =null;
        private OutputStream outputStream = null;

        public HttpResuestResponseStreamWrap(InputStream is, HttpURLConnection httpUrlConn, OutputStream os) {
            this.inputStream = is;
            this.httpUrlConn = httpUrlConn;
            this.outputStream = os;
        }

        public void close(){
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrlConn!=null){
                 httpUrlConn.disconnect();
            }
        }

        public InputStream getInputStream() {
            return inputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public HttpURLConnection getHttpUrlConn() {
            return httpUrlConn;
        }

        public void setHttpUrlConn(HttpURLConnection httpUrlConn) {
            this.httpUrlConn = httpUrlConn;
        }
    }



}

