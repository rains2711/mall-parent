package com.wx.disparent.mallparent.dao;

import com.wx.disparent.mallparent.commons.inface.IBaseMapper;
import com.wx.disparent.mallparent.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends IBaseMapper<UserEntity>
{
    UserEntity findByUsername(String name ) ;
}
