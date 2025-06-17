package com.item.study.controller;

import com.item.study.model.entity.CategoryEntity;
import com.item.study.model.result.ResultBody;
import com.item.study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 产品管理控制器
 * 商品管理接口一般包括：新增、查询详情、列表、更新、删除等。
 * 下面是一个典型的 RESTful 风格接口设计说明及示例代码。
 * <p>
 * CREATE TABLE category (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * name VARCHAR(128) NOT NULL COMMENT '分类名称',
 * parent_id BIGINT DEFAULT NULL COMMENT '父分类ID，NULL表示顶级分类',
 * level TINYINT NOT NULL DEFAULT 1 COMMENT '分类层级',
 * status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
 * created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 * updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 * );
 */

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    // 新增商品
    @PostMapping(path = "/add", produces = "application/json")
    public ResultBody onAdd(@RequestBody() CategoryEntity body) throws Exception {
        service.addCategory(body);
        return ResultBody.success("分类添加成功");
    }

    @PutMapping("/update")
    public ResultBody onUpdate(@RequestBody CategoryEntity body) throws Exception {
        service.updateCategory(body);
        return ResultBody.success("分类更新成功");
    }

    @PutMapping("/changeStatus")
    public ResultBody changeStatus(@RequestParam Integer id, @RequestParam Integer status) throws Exception {
        service.changeStatus(id, status);
        return ResultBody.success("状态更新成功");
    }

    @DeleteMapping("/delete")
    public ResultBody onDelete(@RequestParam Integer id) throws Exception {
        service.deleteCategory(id);
        return ResultBody.success("分类删除成功");
    }

    @GetMapping("/query")
    public ResultBody onQuery(@RequestParam Integer status, @RequestParam String key) throws Exception {
        return ResultBody.success(service.onQuery(status, key));
    }
}
