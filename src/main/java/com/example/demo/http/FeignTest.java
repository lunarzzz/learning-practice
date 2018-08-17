package com.example.demo.http;


import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-16 13:04
 **/
//@FeignClient(url = "http://localhost:9000")
public interface FeignTest {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("GET /hello")
    User getHello();

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("GET /hello2")
    User getHello1(User user);

    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    @RequestLine("POST /hello3")
    @Body("name={name}&age={age}")
    User getHello2(@Param("name") String name, @Param("age") int age);

    @Headers({"Content-Type: application/form-data", "Accept: application/json"})
    @RequestLine("GET /hello4?client={client}&signature={signature}")
    User getHello3(@Param("client") String client, @Param("signature") String signature);

    @Headers({"Content-Type: application/form-data", "Accept: application/json"})
    @RequestLine("GET /hello5?client={client}&signature={signature}")
    MonitorDTO getHello5(@Param("client") String client, @Param("signature") String signature);

}



