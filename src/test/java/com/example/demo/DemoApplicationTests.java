package com.example.demo;
import com.example.demo.controller.TestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
    TestController testController;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void testLogin() throws  Exception {

        String url = "/test3";

        MvcResult mvcResult = mockMvc.perform(get(url).accept(MediaType.ALL)).andExpect(status().isOk()).andReturn();


        int status = mvcResult.getResponse().getStatus();
        String data = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("zjw",data);

    }

    @Test
    public void testPost() throws Exception {
        String url = "/test2";
            MvcResult mvcResult = mockMvc.perform(post(url).param("name","zjw").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
        String data = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("hello_zjw",data);
    }
}