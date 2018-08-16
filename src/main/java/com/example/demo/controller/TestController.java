package com.example.demo.controller;

import com.example.demo.test.ContentDTO;
import com.example.demo.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private Test test;

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(String name){
        System.out.println("hello world");
        return test.hello("zjw");
    }

    @RequestMapping(value = "uploadOriginByCopy", method = RequestMethod.POST)
    @ResponseBody
    public String uploadOriginByCopy(String content){
        System.out.println(content);
       return content;
    }

    @RequestMapping(value = "test3")
    public String test(){
        System.out.println("hello world");
        return "zjw";
    }
    @RequestMapping(value = "test2", method = RequestMethod.POST)
    public String test2(String name){
        return "hello_"+name;
    }

    public static void main(String[] args) {
      String s = "1234\n\n123\n\n\n\n\n\n\n";
      String[] ss = s.split("\n");
        System.out.println(ss.length);
        for (String sss:ss
             ) {
            System.out.println(sss);
        }
    }
}
