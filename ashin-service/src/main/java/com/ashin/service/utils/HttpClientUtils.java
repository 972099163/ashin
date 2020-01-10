package com.ashin.service.utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientUtils {
	private static Logger log = Logger.getLogger(DateUtils.class);
	/**
	 * http post json数据
	 * @param url
	 * @param jsonData
	 * @return
	 */
	public static String sendRequest(String url, String jsonData) {
        HttpURLConnection httpURLConnection = null;
        DataOutputStream printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            httpURLConnection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("contentType", "UTF-8");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            // 获取URLConnection对象对应的输出流
            printWriter = new DataOutputStream(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(jsonData.getBytes("utf-8"));
            // flush输出流的缓冲
            printWriter.flush();
            // 根据ResponseCode判断连接是否成功
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
            	System.out.println(" Error===" + responseCode);
            } else {
            	System.out.println("Post Success!");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));

            StringBuffer responseResult = new StringBuffer();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseResult.append(line);
            }

            return responseResult.toString();

        } catch (Exception e) {
        	log.error("error",e);
        } finally {
        	if(httpURLConnection != null){ 
        		httpURLConnection.disconnect();
        	}
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception ex) {
            	log.error("error",ex);
            }
        }
        return null;
    }
}
