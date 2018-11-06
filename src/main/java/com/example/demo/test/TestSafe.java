package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @ClassNameTestSafe
 * @Description TODO
 * @Author apple
 * @Date 2018/8/25 2:57 PM
 * @Version 1.0
 */
@Component
public class TestSafe {

   private static volatile int count= 0;

   private TestSafe(){
   }
   @Autowired
   private Test test;

   public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
      Field test = TestSafe.class.getField("test");
//      Class
//      Field f = new Field();
//      f.setAccessible(true);
//      f.set(new Test(), new TestSafe());
//      f.set
//
   }
    //
//    public int
}
