package com.mon.aichat.controller;

import com.mon.aichat.model.body.ApprovalBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 审批管理
 */

@RestController
@RequestMapping("/approval")
public class ApprovalController {
    @Autowired
    ApprovalService service;

    /**
     * 添加
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody onCreate(@RequestBody() ApprovalBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody onQuery(@RequestParam("size") Integer size, @RequestParam("page") Integer page) throws Exception {
        return ResultBody.success(service.query(size, page));
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody onUpdate(@RequestBody() ApprovalBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 处理 -需要审批人权限
     * 0: 待审批, 1: 通过, 2: 拒绝
     */
    @RequestMapping(value = "handle", method = RequestMethod.PUT)
    public ResultBody onHandle(@RequestParam("id") Integer id, @RequestParam("status") Integer status) throws Exception {
        return ResultBody.success(service.handle(id, status));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody onDelete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }
}
