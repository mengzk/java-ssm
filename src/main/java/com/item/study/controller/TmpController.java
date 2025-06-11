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
     * 添加预约
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 查询预约
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                                @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新预约
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() String body) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 删除预约
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(0);
    }
}
