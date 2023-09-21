package com.jayschen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jayschen.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
