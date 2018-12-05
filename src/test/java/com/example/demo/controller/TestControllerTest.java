
package com.example.demo.controller;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


//    FeignTest feignTest;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test2() throws Exception {

        Map<java.lang.String, Object> map = new HashMap<>();
        map.put("name","zjw");
        Name name = new Name();
        name.setName("zjw");
        MvcResult result  = mockMvc.perform(post("test2")
                .param("name","zjw"))
                .andExpect(status().isOk()).andReturn();
//        MvcResult result = mockMvc.perform(post("test2").
//                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(name)))
//                .andExpect(status().isOk())// 模拟向testRest发送post请求
//                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))// 预期返回值的媒体类型
//                .andReturn();// 返回执行请求的结果
        Assert.assertEquals(result.getResponse().getContentAsString(),"hello zjw");

    }

    private class Name{
        private java.lang.String name;

        public java.lang.String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
//
//    @Test
//    public void testQ1() throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "zhangjiawei");
//
//        MvcResult result = mockMvc.perform(get("/zjw/test?name=zhangjiawei").content(JSONObject.toJSONString(map)))
//                .andExpect(status().isOk())// 模拟向testRest发送get请求
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
//                .andReturn();// 返回执行请求的结果
//
//        System.out.println(result.getResponse().getContentAsString());
//    }

//    @Test
//    public void name() {
//        JSONObject jsonObject = feignTest.get();
//        assertNotNull(jsonObject);
//    }
}
