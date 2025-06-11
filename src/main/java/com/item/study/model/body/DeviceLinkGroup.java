package com.item.study.model.body;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class DeviceLinkGroup {
    public List<Integer> ids;
    public int gid;
    public String time;

    @Override
    public String toString() {
        return "DeviceLinkGroup{" +
                "ids=" + ids +
                ", gid=" + gid +
                ", time='" + time + '\'' +
                '}';
    }
}
