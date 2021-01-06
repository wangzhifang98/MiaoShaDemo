package com.ms.controller;

import com.ms.controller.viewobject.UserVO;
import com.ms.error.BussinessException;
import com.ms.reponse.CommonReturnType;
import com.ms.service.UserService;
import com.ms.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author 王智芳
 * @data 2020/12/30 16:10
 */
@RestController
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/get")
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id) throws BussinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        //测试统一异常处理
        if(userModel == null){
            userModel.setEncrptPassword("321");
            //throw new BussinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO = convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);
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

    //用户获取otp短信接口
    @RequestMapping("/getotp")
    public CommonReturnType getOtp(@RequestParam(name="telphone")String telphone){
        //需要按照一定规则生成OTP验证码
        Random random = new Random();
         int randomInt= random.nextInt(99999);
         randomInt+=100000;
         String otpCode = String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联
        httpServletRequest.getSession().setAttribute(telphone,otpCode);
        System.out.printf("telphone = %s & otpCode = %s%n", telphone, otpCode);
        //将OTP验证码通过短信通道发送给用户,省略

        return CommonReturnType.create(null);
    }
}
