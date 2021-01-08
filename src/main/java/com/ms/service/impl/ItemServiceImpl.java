package com.ms.service.impl;

import com.ms.dao.ItemDOMapper;
import com.ms.dao.ItemStockDOMapper;
import com.ms.dataobject.ItemDO;
import com.ms.dataobject.ItemStockDO;
import com.ms.error.BussinessException;
import com.ms.error.EmBusinessError;
import com.ms.service.ItemService;
import com.ms.service.model.ItemModel;
import com.ms.validator.ValidationResult;
import com.ms.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private ItemDOMapper itemDOMapper;
    @Autowired
    private ItemStockDOMapper itemStockDOMapper;
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
        ItemDO itemDO = this.convertItemDoFromItemModel(itemModel);
        //写入数据库
        itemDOMapper.insertSelective(itemDO);

        itemModel.setId(itemDO.getId());
        ItemStockDO itemStockDO = convertItemStockDoFromItemModel(itemModel);

        itemStockDOMapper.insertSelective(itemStockDO);
        //返回创建完成的对象
        return this.getItemById(itemModel.getId());
    }
    //转化itemodel->dataobiect
    private ItemDO convertItemDoFromItemModel(ItemModel itemModel){
        //非空判断
        if(itemModel==null){
            return null;
        }
        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel,itemDO);
        itemDO.setPrice(itemModel.getPrice());
        return itemDO;
    }
    //转化itestockmodel->dataobiect
    private ItemStockDO convertItemStockDoFromItemModel(ItemModel itemModel){
        //非空判断
        if(itemModel==null){
            return null;
        }
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setItemId(itemModel.getId());
        itemStockDO.setStock(itemModel.getStock());
        return itemStockDO;
    }
    //商品列表
    @Override
    public List<ItemModel> listItem() {
        return null;
    }
    //获取商品详情
    @Override
    public ItemModel getItemById(Integer id) throws BussinessException {
        //入参校验
        if(id == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        //操作获得库存数量
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());
        //itemDO+itemStockDO=itemmodel
        ItemModel itemModel = convertItemModelFromItemDo(itemDO, itemStockDO);
        return itemModel;
    }
    //itemDO+itemStockDO=itemmodel
    private ItemModel convertItemModelFromItemDo(ItemDO itemDO,ItemStockDO itemStockDO){
        //非空判断
        if(itemDO==null||itemStockDO==null){
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO,itemModel);
        itemModel.setStock(itemStockDO.getStock());
        return itemModel;
    }

}
