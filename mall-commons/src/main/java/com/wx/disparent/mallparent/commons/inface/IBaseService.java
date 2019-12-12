package com.wx.disparent.mallparent.commons.inface;

import java.util.List;
import java.util.Map;

public interface IBaseService<T>
{
      List<T> findAll(Map<String,Object> params) ;

      T findById(int t) ;

      int insert(T t) ;

      int update(T t) ;

      int deleteById(int t) ;

}
