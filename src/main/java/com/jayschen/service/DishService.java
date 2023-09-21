package com.jayschen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jayschen.dto.DishDto;
import com.jayschen.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveWithDishFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

    public void deleteWithFlavor(Long[] ids);
}

