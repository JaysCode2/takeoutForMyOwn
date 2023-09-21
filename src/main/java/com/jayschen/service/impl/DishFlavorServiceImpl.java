package com.jayschen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.entity.DishFlavor;
import com.jayschen.mapper.DishFlavorMapper;
import com.jayschen.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
