package com.ms.service.impl;

import com.ms.dao.UserDOMapper;
import com.ms.dao.UserPasswordDOMapper;
import com.ms.dataobject.UserDO;
import com.ms.dataobject.UserPasswordDO;
import com.ms.service.UserService;
import com.ms.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王智芳
 * @data 2020/12/30 17:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    //根据用户id，查找用户
    @Override
    public UserModel getUserById(Integer id) {
        //调用userdomapper获取到对应的用户dataobject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO, userPasswordDO);
    }
    //userdo+userpassword0=usermodel
    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        //判空处理
        if(userDO == null || userPasswordDO == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);

        userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());

        return userModel;
    }
}
