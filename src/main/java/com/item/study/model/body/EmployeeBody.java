package com.item.study.model.body;

import java.util.List;

/**
 * Author: Meng
 * Date: 2025-01-15
 * Desc:
 */
public class EmployeeBody {
    public Integer departmentId;
    public Integer companyId;
    public String auth="";
    public String memo="";
    public List<Integer> ids;
    public List<ItemUser> list;

    public static class ItemUser {
        public Integer id;
        public String name;
    }

}
