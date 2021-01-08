package com.ms.service.impl;

import com.ms.error.BussinessException;
import com.ms.error.EmBusinessError;
import com.ms.service.ItemService;
import com.ms.service.model.ItemModel;
import com.ms.validator.ValidationResult;
import com.ms.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 王智芳
 * @data 2021/1/8 10:28
 */
@Service
public class ItemServiceImpl implements ItemService {
    //校验器
    @Autowired
    private ValidatorImpl validatorimpl;
    //创建商品
    @Transactional
    @Override
    public ItemModel createItem(ItemModel itemModel) throws BussinessException {
        //校验入参
        ValidationResult validationResult= validatorimpl.validated(itemModel);
        if(validationResult.isHasErrors()){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,validationResult.getErrMsg());
        }
        //转化itemodel->dataobiect
        //写入数据库
        //返回创建完成的对象
        return null;
    }
    //商品列表
    @Override
    public List<ItemModel> listItem() {
        return null;
    }
    //获取商品详情
    @Override
    public ItemModel getItemById(Integer id) {
        return null;
    }
}
