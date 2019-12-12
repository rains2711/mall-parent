package com.wx.disparent.mallparent.controller;

import com.wx.disparent.mallparent.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/f")
public class IndexControl {
    @RequestMapping("/ff")
    public String geta() {
        return "index";
    }

    @RequestMapping("/u")
    public String getu() {
        System.out.println(11);
        return "user/user";
    }
}
