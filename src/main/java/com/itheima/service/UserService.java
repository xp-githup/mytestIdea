package com.itheima.service;

import com.itheima.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService implements UserDetailsService {
   public static BCryptPasswordEncoder s = new BCryptPasswordEncoder();
    public static Map<String, User> map = new HashMap<>();
    static {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(s.encode("admin"));
        User user2 = new User();
        user2.setUsername("zhangsan");
        user2.setPassword(s.encode("123"));

        map.put(user1.getUsername(), user1);
        map.put(user2.getUsername(), user2);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("username:"+s);
        User userInDb = map.get(s);// 模拟查询用户
         if(userInDb==null){
             return null;
             }
             // 模拟数据库中的密码
        String passwordInDb = userInDb.getPassword();
        List<GrantedAuthority> list = new ArrayList<>();

        // 添加一些权限
        list.add(new SimpleGrantedAuthority("add")); // 权限
        list.add(new SimpleGrantedAuthority("delete")); // 权限
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 角色

        // 返回user 参数1 真实用户姓名 参数二 用户的密码 参数三 权限的集合：
        UserDetails user = new org.springframework.security.core.userdetails.User(s,passwordInDb,list);
        System.out.println(passwordInDb);
return user;

    }
}
