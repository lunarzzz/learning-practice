package com.example.demo.controller;

import com.example.demo.test.ContentDTO;
import com.example.demo.test.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "test api")
public class TestController {

    @Autowired
    private Test test;

    @ApiOperation(value = "用户新增" , notes = "")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Res test(@RequestBody User user){
        System.out.println(user.getUsername() + " " + user.getPassword());

        return new Res(200, "succeeeeeeee");
    }

//    @ApiOperation(value = "用户新增" , notes = "")
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
//    public Res test( String username,  String password){
//        System.out.println(username + " " + password);
//
//        return new Res(200, "succeeeeeeee");
//    }


    @ApiOperation(value = "用户新增" , notes = "")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(String name){
        System.out.println("hello world");
        return test.hello("zjw");
    }

    @RequestMapping(value = "uploadOriginByCopy", method = RequestMethod.POST)
    @ApiOperation(value = "用户新增")
    public String uploadOriginByCopy(String content){
        System.out.println(content);
       return content;
    }

    @ApiOperation(value = "用户select")
    @GetMapping(value = "test3")
    public String test(){
        System.out.println("hello world");
        return "zjw";
    }

    @RequestMapping(value = "test2", method = RequestMethod.POST)
    @ApiOperation(value = "用户新增2")
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

@Data
@AllArgsConstructor
class Res{
    int code ;
    String data;
}
