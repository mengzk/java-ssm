package com.mon.aichat.controller;

import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.body.EmployeeBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 部门管理
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    //
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() DepartmentBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("cId") Integer cId) throws Exception {
        return ResultBody.success(service.query(cId));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam("cId") Integer cId) throws Exception {
        return ResultBody.success(service.count(cId));
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() DepartmentBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "queryEmployee", method = RequestMethod.GET)
    public ResultBody queryEmployee(@RequestParam(value = "cId", required = false) Integer cId,
                                 @RequestParam(value = "dId", required = false) Integer dId) throws Exception {
        return ResultBody.success(service.queryStaff(cId,dId));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    public ResultBody addEmployee(@RequestBody EmployeeBody body) throws Exception {
        return ResultBody.success(service.addStaff(body));
    }

    /**
     * 移除
     */
    @RequestMapping(value = "removeEmployee", method = RequestMethod.POST)
    public ResultBody removeEmployee(@RequestBody EmployeeBody body) throws Exception {
        return ResultBody.success(service.removeStaff(body));
    }

    /**
     * 移动到其他部门
     */
    @RequestMapping(value = "moveEmployee", method = RequestMethod.POST)
    public ResultBody moveEmployee(@RequestBody EmployeeBody body) throws Exception {
        return ResultBody.success(service.moveStaff(body));
    }
}
