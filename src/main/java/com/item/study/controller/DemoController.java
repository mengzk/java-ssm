package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

//@RestController
//@RequestMapping("/rest")
public class DemoController {

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

    // 批量新增商品 @PostMapping("/batch")

    // 批量删除
    @DeleteMapping("/batch")
    public ResultBody batchDelete(@RequestBody List<Long> ids) {
        // 批量删除逻辑
        return ResultBody.success(0);
    }

    // 批量更新商品
    @PutMapping("/batch")
    public ResultBody batchUpdate(@RequestBody List<String> goodsDTOs) {
        // 批量更新逻辑
        return ResultBody.success(0);
    }

    // 查询商品数量
    @GetMapping("/count")
    public ResultBody count(@RequestParam(value = "tag", required = false) Integer tag,
                            @RequestParam(value = "status", required = false) Integer status) {
        // 查询数量逻辑
        return ResultBody.success(0);
    }
}
