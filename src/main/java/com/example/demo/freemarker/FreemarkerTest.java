package com.example.demo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameFreemarkerUtils
 * @Description TODO
 * @Author apple
 * @Date 2018/8/3 12:32 AM
 * @Version 1.0
 */
//@Component
public class FreemarkerTest {

    private static final String CLASS_PATH = "src/main/resources/freemarker";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例

        Writer out = null;
        try {
            // step2 获取模版路径
            File file = new File("src/main/java/com/example/demo/freemarker");
            System.out.println(file.getAbsoluteFile());
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("header", Arrays.asList("name","age"));
            dataMap.put("userList", Arrays.asList(new User("zhangjiawei", 12),new User("dajiahao", 1112)));
            dataMap.put("helloWorld", "通过简单的 代码自动生产程序 演示 FreeMarker的HelloWorld！");
            // step4 加载模版文件
            Configuration configuration = FreemarkerConfig.getConfiguration();
            Template template = configuration.getTemplate("hello.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH  + "/hello.html");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);

            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^AutoCodeDemo.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}




