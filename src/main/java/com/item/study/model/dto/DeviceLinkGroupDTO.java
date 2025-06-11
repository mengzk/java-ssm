package com.item.study.model.dto;


/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc: 设备模型关联
 */
public class DeviceLinkGroupDTO {
    private int id;
    private int did;
    private int gid;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
