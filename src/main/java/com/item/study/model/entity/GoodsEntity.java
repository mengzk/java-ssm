package com.item.study.model.entity;

import com.item.study.model.body.GoodsBody;

import java.util.Date;
import java.util.List;

public class GoodsEntity {
    public Integer id;
    public String name;
    public int status;
    public String cover;
    public String description;
    public List<GoodsBody.GoodsSku> skus;
    public List<GoodsBody.GoodsSpec> specs;
    public Date createdAt;
    public Date updatedAt;

    public static class GoodsSpec {
        public Integer id;
        public String name;
        public List<GoodsBody.GoodsSpecValue> values;
    }

    public static class GoodsSpecValue {
        public Integer id;
        public String value;
    }

    public static class GoodsSku {
        public Integer id;
        public String value;
        public int price;
        public int stock;
        public int sold;
        public int status;
        public String cover;
        public String specValueIds;
    }
}
