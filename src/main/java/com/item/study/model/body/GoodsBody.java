package com.item.study.model.body;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class GoodsBody {
    public Integer id;
    public String name;
    public Integer status;
    public String cover;
    public String description;
    public List<GoodsSkuBody> skus;
    public List<GoodsSpecBody> specs;


    @Override
    public String toString() {
        return "GoodsBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

