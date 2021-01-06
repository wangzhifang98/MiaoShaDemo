package com.ms.controller;

import com.ms.service.UserService;
import com.ms.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王智芳
 * @data 2020/12/30 16:10
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public UserModel getUser(@RequestParam(name = "id")Integer id){
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        return userModel;
    }
}
