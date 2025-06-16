package com.item.study.model.result;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class ResultList<T> {
    public int total;
    public int page;
    public int size;
    public boolean more;
    public List<T> list;

    public ResultList(List<T> list, int total, int page, int size) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.list = list;
        this.more = total > size * page;
    }

    public static <T> ResultList<T> ok(List<T> list, int total, int page, int size) {
        return new ResultList<T>(list, total, page, size);
    }

    public static <T> ResultList<T> create(List<T> list, int total, int page, int size) {
        return new ResultList<T>(list, total, page, size);
    }
}
