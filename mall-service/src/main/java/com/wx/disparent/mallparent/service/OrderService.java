package com.wx.disparent.mallparent.service;

import com.wx.disparent.mallparent.commons.inface.IBaseService;
import com.wx.disparent.mallparent.dao.OrderMapper;
import com.wx.disparent.mallparent.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 曾右权
 * @description
 * @date 2019/12/9 19:11
 */

@Service
public class OrderService implements IBaseService<OrderEntity> {
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderEntity> findAll(Map<String, Object> params) {
        return orderMapper.findAll(params);
    }

    public OrderEntity findById(int t) {
        return orderMapper.findById(t);
    }

    public int insert(OrderEntity orderEntity) {
        return orderMapper.insert(orderEntity);
    }

    @Override
    public int update(OrderEntity orderEntity) {
        return orderMapper.update(orderEntity);
    }

    public int deleteById(int t) {
        return orderMapper.deleteById(t);
    }

}
