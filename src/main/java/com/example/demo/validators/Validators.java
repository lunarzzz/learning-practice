package com.example.demo.validators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static java.lang.String.format;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 19:12
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validators {

    public static <T> Validation<T> nonEmpty(){
        return nonEmpty("require not null");
    }

    public static <T> Validation<T> nonEmpty(String msg){
        return SimpleValidation.form(Objects::nonNull,msg);
    }

//    public static Validation<String> moreThan(int size) {
//        return nonEmpty().and(moreThan(size, "size over"));
//    }

//    public static Validation<String> moreThan(int size, String msg) {
//        return nonEmpty().and(SimpleValidation.form((s) -> s.length() >= size, msg));
//    }


//    public static Validation<String> lessThan(int size, String msg) {
//        return nonEmpty().and(SimpleValidation.form(s -> s.length() >= size, msg));
//    }





}
