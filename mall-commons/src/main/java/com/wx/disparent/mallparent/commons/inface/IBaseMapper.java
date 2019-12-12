package com.wx.disparent.mallparent.commons.inface;

import java.util.List;
import java.util.Map;

public interface IBaseMapper<T> {

    //新增接口
    int insert(T t) ;
    //根据ID查询
    T findById(int t);

    int deleteById(int id) ;

    int update(T t) ;

    List<T> findAll(Map<String,Object> params) ;


}
