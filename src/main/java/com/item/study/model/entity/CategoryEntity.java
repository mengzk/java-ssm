package com.item.study.model.entity;

import java.util.Date;

public class CategoryEntity {
    public Integer id;
    public Integer status;
    public Integer parentId; // 0: root category
    public String name;
    public Date createdAt;
//    public String memo; // 0: normal, 1: deleted
}
