package com.wx.disparent.mallparent.controller;

import com.wx.disparent.mallparent.entity.OrderEntity;
import com.wx.disparent.mallparent.entity.UserEntity;
import com.wx.disparent.mallparent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/d")
public class Test {
//    @RequestMapping("/d")
//    public UserEntity getaa(ModelMap map, String id){
//        map.addAttribute("aa",id);
//        UserEntity userEntity=new UserEntity();
//        userEntity.setRealName(id);
////        Map<String,String> map1=new HashMap<>();
////        map1.put("aa",id);
//        return userEntity;
//    }
    @Autowired
    private OrderService orderService;

    @RequestMapping("/insert")
    public int insertOrderTest(){
        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setId(0);
        orderEntity.setTotalNum(2);
        orderEntity.setPayMoney(100);
        orderEntity.setPayType("zhifubao");
        orderEntity.setTransactionId("dfsadfsd");
        orderEntity.setProductId(1);

//        orderEntity.setIsDelete("0");
//        OrderService orderService = new OrderService();
        int insert = orderService.insert(orderEntity);
        return insert;
    }

    @RequestMapping("/select")
    public OrderEntity selectOrderTest(){
//        Integer integer = 00000000000000000000000000000001;
        OrderEntity orderEntity = orderService.findById(1);
        return orderEntity;
    }

    @RequestMapping("/selectAll")
    public List selectAllOrderTest(){
        List list = orderService.findAll(null);
        return list;
    }

    @RequestMapping("/update")
    public int updateOrderTest(){
        System.out.println("update");
        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setId(1);
        orderEntity.setTotalNum(6);
        int i = orderService.update(orderEntity);
        System.out.println("updateEnd");
        return i;
    }

    @RequestMapping("/delete")
    public int  deleteOrderTest(){
        int i = orderService.deleteById(00000000000000000000000000000001);
        return i;
    }




}
