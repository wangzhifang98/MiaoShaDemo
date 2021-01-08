package com.ms.service.model;

import java.math.BigDecimal;

/**
 * @author 王智芳
 * @data 2021/1/8 9:51
 */
public class ItemModel {
    //商品id
    private Integer id;
    //商品名称
    private String title;
    //商品价格
    private BigDecimal price;
    //商品的库存
    private Integer stock;
    //商品描述
    private String description;
    //商品销量
    private Integer sales;
    //商品描述图片
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemModel{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", description='").append(description).append('\'');
        sb.append(", sales=").append(sales);
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
