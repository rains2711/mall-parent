package com.wx.disparent.mallparent.dao;

import com.wx.disparent.mallparent.commons.inface.IBaseMapper;
import com.wx.disparent.mallparent.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author 刘杰龙
 * @version 1.0
 * @description 商品dao层
 * @date 2019/12/9 19:15
 */
@Repository
@Mapper
public interface ProductMapper extends IBaseMapper<ProductEntity> {
    ProductEntity findByProductName(String name);

    //改变商品状态 1.上架  2.下架
    int changeStatus(Map<String, Object> params);
}
