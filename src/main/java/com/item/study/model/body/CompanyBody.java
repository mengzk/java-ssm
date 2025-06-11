package com.item.study.model.body;

/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc:
 */
public class CompanyBody {
    public Integer id;
    public Integer uid;
    public Integer level; // 0普通 1VIP
//    public Integer status;
    public String name;
    public String logo;
    public String description;
    public String address;
    public Double lat;
    public Double lng;
//    public Date time = new Date();

    @Override
    public String toString() {
        return "CompanyBody{" +
                "id=" + id +
                ", uid=" + uid +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
