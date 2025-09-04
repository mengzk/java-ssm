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
    public List<GoodsSkuEntity> skus;
    public List<GoodsSpecEntity> specs;
    public Date createdAt;
    public Date updatedAt;
}
