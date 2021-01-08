package com.ms.service;

import com.ms.error.BussinessException;
import com.ms.service.model.ItemModel;

import java.util.List;

/**
 * @author 王智芳
 * @data 2021/1/8 10:23
 */
public interface ItemService {
    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BussinessException;

    //商品列表浏览
    List<ItemModel> listItem();

    //商品详情浏览
    ItemModel getItemById(Integer id) throws BussinessException;
}
