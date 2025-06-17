package com.item.study.model.entity;

import java.util.Date;

public class CategoryEntity {
    public int id;
    public int status;
    public int parentId; // 0: root category
    public String name;
    public Date createdAt;
//    public String memo; // 0: normal, 1: deleted
}
