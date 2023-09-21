package com.jayschen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.common.CustomException;
import com.jayschen.dto.SetmealDto;
import com.jayschen.entity.Setmeal;
import com.jayschen.entity.SetmealDish;
import com.jayschen.mapper.SetmealMapper;
import com.jayschen.service.DishService;
import com.jayschen.service.SetmealDishService;
import com.jayschen.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private SetmealDishService setmealDishService;

    @Autowired
    private DishService dishService;

    @Override
    /**
     * 多表添加
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        setmealService.save(setmealDto);
        Long setmealId = setmealDto.getId();

        List<SetmealDish> dishs = setmealDto.getSetmealDishes();

        for (SetmealDish setmealDish : dishs) {
            setmealDish.setSetmealId(setmealId);
        }

        setmealDishService.saveBatch(dishs);
    }

    /**
     * 多表删除
     *
     * @param ids
     */
    @Override
    @Transactional
    public void deleteWithDish(Long[] ids) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(Setmeal::getId, ids);
        queryWrapper.eq(Setmeal::getStatus, 1);
        int count = setmealService.count(queryWrapper);

        if (count > 0) {
            //正在售卖，无法删除
            throw new CustomException("当前商品正在售卖，不能删除");
        }

        LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        for (Long id : ids) {
            setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId, id);
            setmealDishService.remove(setmealDishLambdaQueryWrapper);
            setmealService.removeById(id);
        }
    }

    @Override
    public SetmealDto getWithSeatMealDish(Long id) {
        Setmeal setmeal = setmealService.getById(id);
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal, setmealDto);

        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SetmealDish::getSetmealId, id);
        List<SetmealDish> list = setmealDishService.list(lambdaQueryWrapper);
        setmealDto.setSetmealDishes(list);
        return setmealDto;
    }

    @Override
    public void updateWithSeatMealDish(SetmealDto setmealDto) {
        setmealService.updateById(setmealDto);
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SetmealDish::getSetmealId, setmealDto.getId());
        setmealDishService.remove(queryWrapper);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();

        for (SetmealDish setmealDish : setmealDishes) {
            setmealDish.setSetmealId(setmealDto.getId());
        }

        setmealDishService.saveBatch(setmealDishes);
    }

    @Override
    public SetmealDto getByIdWithSetmealDish(Long id) {
        Setmeal setmeal = setmealService.getById(id);
        SetmealDto setmealDto = new SetmealDto();

        BeanUtils.copyProperties(setmeal, setmealDto);
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId, id);
        List<SetmealDish> list = setmealDishService.list(queryWrapper);
        setmealDto.setSetmealDishes(list);

        return setmealDto;
    }
}
