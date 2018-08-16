package com.example.demo.validators;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 19:37
 **/

public class TestValidation {

    @Test
    public void get(){
//        ValidationResult test = Validators.moreThan(3, "less bala").test("12");
//        Assert.assertEquals("less bala", test.getMessage());
        String message = Validators.nonEmpty().test(null).getMessage();
        assertEquals("require not null", message);
    }
}
