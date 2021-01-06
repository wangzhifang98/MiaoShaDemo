package com.ms.error;

/**
 * @author 王智芳
 * @data 2021/1/6 13:11
 */
//包装类业务类异常实现
public class BussinessException extends Exception implements CommonError{

    private CommonError commonError;

    //直接接收EmBusinessError的传参用于构造业务异常
    public BussinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }
    //接收自定义的errorMessage的方式构造业务异常
    public BussinessException(CommonError commonError,String errorMessage){
        super();
        this.commonError = commonError;
        this.commonError.setErrorMessage(errorMessage);
    }


    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return this.commonError.getErrorMessage();
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.commonError.setErrorMessage(errorMessage);
        return this;
    }
}
