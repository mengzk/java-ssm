package com.mon.aichat.model.body;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class TaskBody {
    public Integer id;
    public Integer uid;
    public Integer status;
    public int level; // 优先级
    public int type3; // 类型
    public String title;
    public String content;
    public String reason;
    public String attachments; // 附件 传递路径或者id
    public Date createTime;
}
