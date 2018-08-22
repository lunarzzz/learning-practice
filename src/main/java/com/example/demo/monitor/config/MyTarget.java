package com.example.demo.monitor.config;

import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.constant.MonitorConstant;
import feign.Request;
import feign.RequestTemplate;
import feign.Target;

import static feign.Util.checkNotNull;
import static feign.Util.emptyToNull;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-21 11:21
 **/
class MyTarget implements Target<MonitorResponseDTO> {

    private final Class<MonitorResponseDTO> type;
    private final String name;
    private final String url;


    public MyTarget(Class<MonitorResponseDTO> type, String url) {
        this(type, url, url);
    }

    public MyTarget(Class<MonitorResponseDTO> type, String name, String url) {
        this.type = checkNotNull(type, "type");
        this.name = checkNotNull(emptyToNull(name), "name");
        this.url = checkNotNull(emptyToNull(url), "url");
    }

    @Override
    public Class<MonitorResponseDTO> type() {
        return type;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Request apply(RequestTemplate input) {
        if (input.url().indexOf("http") != 0) {
            input.insert(0, url());
            try {
//                input.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return input.request();
    }

    private String buildSignature() throws Exception {
        return "name=" + MonitorConstant.APP_NAME + "&" + "signature=" + SignatureProvider.getSignature();

    }
}
