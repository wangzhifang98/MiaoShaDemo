package com.ms.service.impl;

import com.ms.dao.UserDOMapper;
import com.ms.dao.UserPasswordDOMapper;
import com.ms.dataobject.UserDO;
import com.ms.dataobject.UserPasswordDO;
import com.ms.error.BussinessException;
import com.ms.error.EmBusinessError;
import com.ms.service.UserService;
import com.ms.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if(userDO == null){
            return null;
        }
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

    //注册用户
    @Override
    @Transactional
    public void register(UserModel userModel) throws BussinessException {
        if(userModel == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if(StringUtils.isEmpty(userModel.getName())
                ||userModel.getGender() == null
                ||userModel.getAge() == null
                ||StringUtils.isEmpty(userModel.getTelphone())){
            throw  new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //实现model->dataobject方法
       UserDO userDO = convertFromModel(userModel);
        //插入用户信息
       userDOMapper.insertSelective(userDO);

       UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
       //插入用户密码
        userPasswordDOMapper.insertSelective(userPasswordDO);

        return;
    }
    //实现model->dataobject方法
    private UserDO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }
    private UserPasswordDO convertPasswordFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }

}
