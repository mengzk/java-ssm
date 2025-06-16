package com.item.study.model.body;

import java.util.Date;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class GoodsBody {
    public Integer id;
    public String name;
    public int status;
    public String cover;
    public String description;
    public List<GoodsSku> skus;
    public List<GoodsSpec> specs;

    public static class GoodsSpec {
        public Integer id;
        public String name;
        public List<GoodsSpecValue> values;
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

