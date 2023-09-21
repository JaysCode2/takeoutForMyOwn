package com.jayschen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.entity.OrderDetail;
import com.jayschen.mapper.OrderDetailMapper;
import com.jayschen.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
