package com.example.demo.controller;

import com.example.demo.controller.constant.ResponseConstant;
import org.springframework.ui.ModelMap;

/**
 * Desc:返回对象构造器
 *
 * @author wei.zw
 * @since 2017年6月5日 上午10:43:15
 * @version v 0.1
 */
public class ResultBuilder {

    private ModelMap modelMap = new ModelMap();

    public ResultBuilder addRetCode(int retCode) {
        modelMap.put(ResponseConstant.RET_CODE, retCode);
        return this;
    }

    public ResultBuilder addRetDesc(String retDesc) {
        modelMap.put(ResponseConstant.RET_DESC, retDesc);
        return this;
    }

    /**
     * 构建一个retCode=400,retDesc= 为自定义的描述的一个返回对象构造器
     *
     * @param retDesc
     * @return
     * @author wei.zw
     */
    public ResultBuilder buildFail(String retDesc) {
        modelMap.put(ResponseConstant.RET_CODE, 400);
        modelMap.put(ResponseConstant.RET_DESC, retDesc);
        return this;
    }

    /**
     * 构建一个retCode=500,retDesc= 为自定义的描述的一个返回对象构造器
     *
     * @param retDesc
     * @return
     * @author wei.zw
     */
    public ResultBuilder buildException(String retDesc) {
        modelMap.put(ResponseConstant.RET_CODE, 500);
        modelMap.put(ResponseConstant.RET_DESC, retDesc);
        return this;
    }

    public ResultBuilder addData(Object data) {
        modelMap.put(ResponseConstant.RET_DATA, data);
        return this;
    }

    public ResultBuilder addErrorMessage(String errorMessage) {
        modelMap.put(ResponseConstant.ERROR_MESSAGE, errorMessage);
        return this;
    }

    public ResultBuilder addExtend(String key, Object value) {
        modelMap.put(key, value);
        return this;
    }

    public ModelMap toResult() {
        return modelMap;
    }

    public static ResultBuilder build() {
        return new ResultBuilder();
    }
}
