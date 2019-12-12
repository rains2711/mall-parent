package com.wx.disparent.mallparent.controller;

import com.wx.disparent.mallparent.entity.UserEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/d")
public class Test {
    @RequestMapping("/d")
    public UserEntity getaa(ModelMap map, String id){
        map.addAttribute("aa",id);
        UserEntity userEntity=new UserEntity();
        userEntity.setRealName(id);
//        Map<String,String> map1=new HashMap<>();
//        map1.put("aa",id);
        return userEntity;
    }
}
