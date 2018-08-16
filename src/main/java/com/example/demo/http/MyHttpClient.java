package com.example.demo.http;

import javafx.scene.chart.ValueAxis;
import  static  org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-16 11:43
 **/
public class MyHttpClient {

    private static String URL = "http://localhost:9000/hello";
    private static String URL_POST = "http://localhost:9000/test";
    private static RestTemplate restTemplate = new RestTemplate();

    private ResponseErrorHandler responseErrorHandler= new ResponseErrorHandler() {
        @Override
        public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
            return true;
        }

        @Override
        public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        }
    };

    @Test
    public  void testRest(){
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        headers.setAccept();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> exchange = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);

        int value = exchange.getStatusCode().value();
        String s = exchange.toString();
        System.out.println(s);

        assertEquals(value,200);
    }

    @Test
    public void name() {

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap body = new LinkedMultiValueMap();

        body.add("name", "zhangjiawei");

        HttpEntity<LinkedMultiValueMap> linkedMultiValueMapHttpEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(URL_POST, HttpMethod.POST, linkedMultiValueMapHttpEntity, String.class);

        String body1 = exchange.getBody();
        assertEquals(200, exchange.getStatusCodeValue());

        assertTrue(exchange.hasBody());
        System.out.println(body1);

//        assertNotNull(body1);
    }
}
