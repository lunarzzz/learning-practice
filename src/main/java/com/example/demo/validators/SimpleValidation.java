package com.example.demo.validators;

import lombok.AllArgsConstructor;

import java.util.function.Predicate;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 18:59
 **/
@AllArgsConstructor
public class SimpleValidation<T> implements Validation<T> {

    private Predicate<T> predicate;

    private String onErrorMessage;

    public static <T> SimpleValidation<T> form(Predicate<T> predicate, String onErrorMessage){
        return new SimpleValidation<>(predicate, onErrorMessage);
    }

    @Override
    public ValidationResult test(T param) {
        return predicate.test(param) ? ValidationResult.ok() : ValidationResult.fail(onErrorMessage);
    }
}
