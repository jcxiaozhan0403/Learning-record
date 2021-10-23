package cn.com.scitc.springbootstudy.config;

import cn.com.scitc.springbootstudy.pojo.Department;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author John.Cena
 * @date 2021/10/22 19:08
 * @Description: Realm
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        Department department = (Department) subject.getPrincipal();

        // 设置角色集合，用Set集合防止重复
        Set<String> roles = new HashSet<>();
        roles.add(department.getDepartmentName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Department department = new Department();
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        new SimpleAuthenticationInfo(department,department.getId(),getName());

        return null;
    }
}
