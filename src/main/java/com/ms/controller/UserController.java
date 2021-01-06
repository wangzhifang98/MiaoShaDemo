package com.ms.controller;

import com.ms.controller.viewobject.UserVO;
import com.ms.service.UserService;
import com.ms.service.model.UserModel;
import org.springframework.beans.BeanUtils;
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
    public UserVO getUser(@RequestParam(name = "id")Integer id){
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        return convertFromModel(userModel);
    }
    //将model转化成vo
    private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }

}
