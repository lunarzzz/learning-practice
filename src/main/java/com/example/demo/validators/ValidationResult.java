package com.example.demo.validators;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 17:43
 **/
@Data
@AllArgsConstructor
public class ValidationResult {

    private boolean valid;
    private String message;
    private String code;

    public static ValidationResult ok(){
        return new ValidationResult(true, null, null);
    }

    public static ValidationResult ok(String code) {
        return new ValidationResult(true, null, code);
    }

    public static ValidationResult fail(String message) {
        return new ValidationResult(false, message, null);
    }

    public static ValidationResult fail(String code, String message) {
        return new ValidationResult(false, message, code);
    }

    public void throwIfInvalid() {
        this.throwMessage(getMessage());
    }

    public void throwIfInvalid(String fieldName) {
        if (!isValid()) throw new ValidatorException(fieldName + " " + getMessage());
    }

//    public <T, R> void throwIfInvalid(TypeFunction<T, R> function) {
//        var fieldName = BladeKit.getLambdaFieldName(function);
//        throwIfInvalid(fieldName);
//    }

    public void throwMessage(String msg) {
        if (!isValid()) throw new ValidatorException(msg);
    }

}
