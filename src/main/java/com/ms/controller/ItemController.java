package com.ms.controller;

import com.ms.controller.viewobject.ItemVO;
import com.ms.error.BussinessException;
import com.ms.reponse.CommonReturnType;
import com.ms.service.ItemService;
import com.ms.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 王智芳
 * @data 2021/1/8 13:47
 */
@RestController
//解决session共享的跨域请求
@CrossOrigin(originPatterns = "*",allowCredentials = "true",allowedHeaders = "*")
public class ItemController extends BaseController{
    @Autowired
    private ItemService itemService;
    //创建商品
    @RequestMapping("/createitem")
    public CommonReturnType createItem(@RequestParam(name = "title")String title,
                                       @RequestParam(name = "price")BigDecimal price,
                                       @RequestParam(name = "stock")Integer stock,
                                       @RequestParam(name = "description")String description,
                                       @RequestParam(name = "imgUrl")String imgUrl) throws BussinessException {
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setDescription(description);
        itemModel.setImgUrl(imgUrl);

        ItemModel item = itemService.createItem(itemModel);
        //model->vo
        ItemVO itemVO = convertFromModel(item);
        return CommonReturnType.create(itemVO);
    }
    //model->vo
    private ItemVO convertFromModel(ItemModel itemModel){
        if(itemModel==null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel,itemVO);
        return itemVO;
    }
    //商品列表浏览
    @RequestMapping("/list")
    public CommonReturnType listItem(){
        return null;
    }

    //商品详情浏览
    @RequestMapping("/getItemById")
    public CommonReturnType getItemById(){
        return null;
    }

}
