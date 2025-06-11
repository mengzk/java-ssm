package com.item.study.model.dto;

/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc: 设备模型关联
 */
public class ModelLinkDevice {
    private int id;
    private int did;
    private int kid;
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

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
