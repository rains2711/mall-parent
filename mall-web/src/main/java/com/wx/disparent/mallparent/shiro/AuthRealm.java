package com.wx.disparent.mallparent.shiro;

import com.wx.disparent.mallparent.entity.Permission;
import com.wx.disparent.mallparent.entity.RoleEntity;
import com.wx.disparent.mallparent.entity.UserEntity;
import com.wx.disparent.mallparent.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取User用户
        UserEntity user = (UserEntity) principals.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<String>();
        List<String> roleNameList = new ArrayList<String>();
        Set<RoleEntity> roleSet = user.getRoles();

        if (roleSet != null) {
            for (RoleEntity role : roleSet) {
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissions();
                if (permissionSet != null) {
                    for (Permission permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        // 需要把角色和权限放入info中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 权限设定
        info.addStringPermissions(permissionList);
        // 角色设定
        info.addRoles(roleNameList);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        UserEntity user = userService.findByUsername(username);
        if (null != user) {
            return new SimpleAuthenticationInfo(user, user.getPasswd(), this.getClass().getName());
        } else {
            return new SimpleAuthenticationInfo();
        }
    }
}
