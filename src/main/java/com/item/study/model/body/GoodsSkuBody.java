package com.item.study.model.body;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class GoodsSkuBody {
    public Integer id;
    public Integer goodsId;
    public String value;
    public int price;
    public int stock;
    public int sold;
    public int status;
    public String cover;
    public String description;
    public List<GoodsSpecBody> specs;

}

