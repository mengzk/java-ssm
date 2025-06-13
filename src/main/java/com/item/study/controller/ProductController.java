package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 产品管理控制器
 * 商品管理接口一般包括：新增、查询详情、列表、更新、删除等。
 * 下面是一个典型的 RESTful 风格接口设计说明及示例代码。
 *
 * 接口设计说明：
 * POST /goods：新增商品
 * GET /goods/{id}：查询商品详情
 * GET /goods：分页查询商品列表
 * PUT /goods/{id}：更新商品
 * DELETE /goods/{id}：删除商品
 */

//@RestController
//@RequestMapping("/product")
public class ProductController {

    // 新增商品
    @PostMapping
    public ResultBody create(@RequestBody String goodsDTO) {
        // 新增逻辑
        return ResultBody.success(0);
    }

    // 查询商品详情
    @GetMapping("/{id}")
    public ResultBody detail(@PathVariable Long id) {
        // 查询逻辑
        return ResultBody.success(0);
    }

    // 分页查询商品列表
    @GetMapping
    public ResultBody list(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer size) {
        // 查询逻辑
        return ResultBody.success(0);
    }

    // 更新商品
    @PutMapping("/{id}")
    public ResultBody update(@PathVariable Long id, @RequestBody String goodsDTO) {
        // 更新逻辑
        return ResultBody.success(0);
    }

    // 删除商品
    @DeleteMapping("/{id}")
    public ResultBody delete(@PathVariable Long id) {
        // 删除逻辑
        return ResultBody.success(0);
    }
}
