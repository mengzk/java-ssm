package com.item.study.model.entity;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc:
 */
public class TaskEntity {
    public int id;
    public int createUid;
    public int status;
    public int level; // 优先级
    public int type3; // 类型
    public String title;
    public String content;
    public String attachments; // 附件 传递路径或者id
    public Date createTime;
    public Date updateTime;
}
