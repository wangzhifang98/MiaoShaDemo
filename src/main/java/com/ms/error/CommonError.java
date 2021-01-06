package com.ms.error;

/**
 * @author 王智芳
 * @data 2021/1/6 11:28
 */
public interface CommonError {
    //错误码
    int getErrorCode();
    //错误信息
    String getErrorMessage();
    //自定义错误信息
    CommonError setErrorMessage(String errorMessage);
}
