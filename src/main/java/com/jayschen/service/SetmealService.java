package com.jayschen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jayschen.dto.SetmealDto;
import com.jayschen.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void deleteWithDish(Long[] ids);

    public SetmealDto getWithSeatMealDish(Long id);

    public void updateWithSeatMealDish(SetmealDto setmealDto);

    SetmealDto getByIdWithSetmealDish(Long id);
}
