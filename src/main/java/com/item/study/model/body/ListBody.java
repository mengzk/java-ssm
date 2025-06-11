package com.item.study.model.body;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class ListBody {
    public int size;
    public int page;
    public boolean desc;
    public String keyword;

    @Override
    public String toString() {
        return "ListBody{" +
                "size=" + size +
                ", page=" + page +
                ", desc=" + desc +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
