package com.mon.aichat.controller;

import com.mon.aichat.model.body.TaskBody;
import com.mon.aichat.model.body.TaskHandleBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 审批管理
 * 一个任务，N条流转记录
 */

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;

    /**
     * 添加
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody onCreate(@RequestBody() TaskBody body) throws Exception {
        return ResultBody.success(service.create(body));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody onQuery(@RequestParam("statue") Integer statue, @RequestParam("size") Integer size, @RequestParam("page") Integer page) throws Exception {
        return ResultBody.success(service.query(statue, size, page));
    }

    /**
     * 详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody onDetail(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.detail(id));
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody onUpdate(@RequestBody() TaskBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 处理 -需要审批人权限
     * 0: 待审批, 1: 通过, 2: 拒绝
     */
    @RequestMapping(value = "handle", method = RequestMethod.PUT)
    public ResultBody onHandle(@RequestBody() TaskHandleBody body) throws Exception {
        return ResultBody.success(service.handle(body));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody onDelete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }
}
