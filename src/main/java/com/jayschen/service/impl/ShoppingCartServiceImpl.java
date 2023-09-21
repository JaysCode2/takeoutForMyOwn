package com.jayschen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.entity.ShoppingCart;
import com.jayschen.mapper.ShoppingCartMapper;
import com.jayschen.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
