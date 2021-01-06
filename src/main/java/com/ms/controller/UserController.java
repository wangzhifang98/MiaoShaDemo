package com.ms.controller;

import com.ms.dao.UserDOMapper;
import com.ms.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王智芳
 * @data 2020/12/30 16:10
 */
@RestController
public class UserController {
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/home")
    public String home(){
        System.out.println("测试controller");
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO != null){
            return "测试用户不存在";
        }
        return "用户存在";
    }
}
