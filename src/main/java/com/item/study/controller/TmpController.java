package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

//@RestController
//@RequestMapping("/tmp")
public class TmpController {

    /**
     * 新增
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 查询详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody detail(@RequestParam("id") Integer id) throws Exception {
        if (id == null || id <= 0) {
            return ResultBody.fail(0, "Invalid ID");
        }
        // Here you would typically fetch the details from the database
        return ResultBody.success(0);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam("page") Integer page,
                                @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "tag", required = false) Integer tag,
                                @RequestParam(value = "status", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询数量
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() String body) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(0);
    }
}
