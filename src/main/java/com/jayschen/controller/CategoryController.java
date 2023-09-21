package com.jayschen.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jayschen.common.R;
import com.jayschen.entity.Category;
import com.jayschen.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加菜品分类
     *
     * @param category
     * @return
     */
    @PostMapping
    private R<String> save(@RequestBody Category category) {
        log.info(category.toString());
        categoryService.save(category);
        return R.success("添加分类成功");
    }

    /**
     * 分页查找菜品分类
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    private R<Page> page(Integer page, Integer pageSize) {
        log.info("page={},pageSize={}", page, pageSize);

        Page<Category> pageInfo = new Page(page, pageSize);

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);

        categoryService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids) {
//        categoryService.removeById(ids);

        categoryService.remove(ids);

        return R.success("删除成功");
    }

    /**
     * 修改套餐
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        categoryService.updateById(category);
        return R.success("修改成功");
    }

    /**
     * 查询种类
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> getType(Category category) {
        //System.out.println(category);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }
}
