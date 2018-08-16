package com.example.demo.validators;

import lombok.Getter;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 17:54
 **/
public class ValidatorException extends RuntimeException {

    @Getter
    private Integer code;

    public ValidatorException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ValidatorException(String message) {
        super(message);
    }
}
