package com.example.demo.monitor.config;

import com.example.demo.monitor.constant.MonitorConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 获取监控系统signature签名；过期时间为一天
 * @author: zhangjiawei
 * @create: 2018-08-21 10:19
 **/
public class SignatureProvider {

    private static Logger logger = LoggerFactory.getLogger(SignatureProvider.class);

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    private static String getMD5(byte[] bytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char str[] = new char[16 * 2];
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte tmp[] = md.digest();
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String(str);
    }

    private static String getMD5(String value) throws Exception {
        String result = "";
        try {
            result = getMD5(value.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
        return result;
    }

    public static String getSignature()  {
        Date today = new Date();
        String signature = "";
        try{
            signature = getMD5(MonitorConstant.APP_NAME+ SIMPLE_DATE_FORMAT.format(today) + MonitorConstant.APP_SECRET);
        }catch (Exception e){
            logger.warn("monitor info signature generation failure");
            e.printStackTrace();
        }
        return signature;
    }

    public static void main(String[] args)  {
        String s = getSignature();
        System.out.println(s);
    }

}
