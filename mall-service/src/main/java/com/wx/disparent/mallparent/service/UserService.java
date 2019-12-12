package com.wx.disparent.mallparent.service;

import com.wx.disparent.mallparent.commons.inface.IBaseService;
import com.wx.disparent.mallparent.dao.UserMapper;
import com.wx.disparent.mallparent.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IBaseService<UserEntity> {

    @Autowired
    private UserMapper userMapper ;

    public List<UserEntity> findAll(Map<String, Object> params) {
        return userMapper.findAll(params);
    }

    public UserEntity findById(int t) {
        return null;
    }

    public int insert(UserEntity userEntity) {
        return 0;
    }

    @Override
    public int update(UserEntity userEntity) {
        return 0;
    }

    public int deleteById(int t) {
        return 0;
    }

    /**
     * 根据用户手机号，用户名，email方式查询用户
     * @param userName
     * @return
     */
    public UserEntity findByUsername(String userName)
    {
        UserEntity userEntity  = userMapper.findByUsername(userName);
        return userEntity ;
    }


}
