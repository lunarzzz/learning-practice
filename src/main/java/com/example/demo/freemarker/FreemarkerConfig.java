package com.example.demo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-16 20:41
 **/
public class FreemarkerConfig {

    private static Configuration configuration;

    private static AtomicBoolean initFlag = new AtomicBoolean(false);

    private static void init() throws IOException {
        if (initFlag.compareAndSet(false,true)){
            configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/freemarker"));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setObjectWrapper(new DefaultObjectWrapper());
        }
    }

    public static Configuration getConfiguration() throws IOException {
        init();
        return configuration;
    }
}
