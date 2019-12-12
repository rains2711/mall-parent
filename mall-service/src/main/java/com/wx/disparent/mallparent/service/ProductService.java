package com.wx.disparent.mallparent.service;

import com.wx.disparent.mallparent.commons.inface.IBaseService;
import com.wx.disparent.mallparent.dao.ProductMapper;
import com.wx.disparent.mallparent.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 商品服务层
 * @author 刘杰龙
 * @version 1.0
 * @date 2019/12/10 9:24
 */
@Service
public class ProductService implements IBaseService<ProductEntity> {
    @Autowired
    private ProductMapper productMapper;
    /**查询所有商品信息*/
    @Override
    public List<ProductEntity> findAll(Map<String, Object> params) {
        List<ProductEntity> productEntities = productMapper.findAll(params);
        return productEntities;
    }

    /**查询单个商品信息*/
    @Override
    public ProductEntity findById(int t) {
        ProductEntity productEntity = productMapper.findById(t);
        return productEntity;
    }

    /**添加新商品*/
    @Override
    public int insert(ProductEntity productEntity) {
        int result = productMapper.insert(productEntity);
        return result;
    }

    /**修改商品信息*/
    @Override
    public int update(ProductEntity productEntity) {
        int result = productMapper.update(productEntity);
        return result;
    }

    @Override
    public int deleteById(int t) {
        return 0;
    }

    /**修改商品状态：1.上架  2.下架*/
    public int changeStatus(int t,String status) {
        Map<String,Object> params = new HashMap();
        if (status.equals("sell")){
            params.put("status","1");
        }else if (status.equals("sold")){
            params.put("status","2");
        }
        params.put("id",t);

        int result = productMapper.changeStatus(params);
        return result;
    }
}
