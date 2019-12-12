package com.wx.disparent.mallparent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wx.disparent.mallparent.commons.util.PageUtil;
import com.wx.disparent.mallparent.entity.UserEntity;
import com.wx.disparent.mallparent.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    final Logger logger = Logger.getLogger(UserController.class) ;

    @Autowired
    private UserService userService ;

    @RequestMapping("findAll")
    public PageInfo list(HttpServletRequest request, HttpServletResponse response)
    {

        Map<String,Object> paramMap = new HashMap<String,Object> () ;
        int pageSize = PageUtil.getPage(request,"pageSize") ;
        int pageNum = PageUtil.getPage(request,"pageNum") ;
        String name = request.getParameter("name") == null || request.getParameter("name").equals("") ? "" :request.getParameter("name");
        paramMap.put("name",name) ;
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userEntityList = userService.findAll(paramMap) ;
        PageInfo<UserEntity> pageInfo = new PageInfo<UserEntity>(userEntityList);
        return  pageInfo ;
    }

    /**
     * 新增用户
     * @param userEntity
     * @return
     */
    @RequestMapping("/add")
    public String addUser(@RequestParam UserEntity userEntity){

        return null ;

    }

    public  String login(UserEntity user){
        //使用 shiro 登录验证
        //1 认证的核心组件：获取 Subject 对象
        Subject subject = SecurityUtils.getSubject();
        //2 将登陆表单封装成 token 对象
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPasswd());
        try {
            //3 让 shiro 框架进行登录验证：
            subject.login(token);
            return "index" ;
        }catch (Exception e){
            logger.error(e);
        }
        return "" ;

    }









}
