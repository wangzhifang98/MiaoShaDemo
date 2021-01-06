package com.ms.error;

/**
 * @author 王智芳
 * @data 2021/1/6 13:02
 */
public enum EmBusinessError implements CommonError{
    //6开头为用户信息相关错误
    USER_NOT_EXIST(60000,"用户不存在"),
    //通用错误类型
    PARAMETER_VALIDATION_ERROR(70000,"参数不合法"),
    //未知错误
    UNKNOWN_ERROR(80000,"未知错误")
    ;

    private int errorCode;
    private String errorMessage;

    private EmBusinessError(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
