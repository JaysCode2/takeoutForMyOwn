package com.jayschen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jayschen.entity.Orders;

public interface OrderService extends IService<Orders> {
    /**
     * 用户下单
     */
    public void submit(Orders orders);
}
