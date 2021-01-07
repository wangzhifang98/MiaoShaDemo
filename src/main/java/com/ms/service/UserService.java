package com.ms.service;

import com.ms.error.BussinessException;
import com.ms.service.model.UserModel;

/**
 * @author 王智芳
 * @data 2020/12/30 17:09
 */
public interface UserService {
    //根据用户id查询用户
    UserModel getUserById(Integer id);
    //注册用户
    void register(UserModel userModel) throws BussinessException;
    //登录校验
    UserModel validateLogin(String telphone,String password) throws BussinessException;
}
