package com.wx.disparent.mallparent.dao;

import com.wx.disparent.mallparent.commons.inface.IBaseMapper;
import com.wx.disparent.mallparent.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author 曾右权
 * @description
 * @date 2019/12/9 19:02
 */

@Repository
@Mapper
public interface OrderMapper extends IBaseMapper<OrderEntity> {

}
