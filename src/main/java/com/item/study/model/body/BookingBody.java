package com.item.study.model.body;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc:
 */
public class BookingBody {
    public Integer id;
    public Integer tag = 0; // 0 会议 1 需求 2 接待
    public Integer status; // 0 未开始 1 进行中 2 已结束
    public Integer uid;
    public Date time = new Date();
    public Date start;
    public Date end;
    public String startDate;
    public String endDate;
    public String theme;
    public String content;
    public String memo;
}
