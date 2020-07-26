package com.fh.service.impl;

import com.fh.mapper.TUserMapper;
import com.fh.model.TUser;
import com.fh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public Map toLogin(String username, String password) {
        Map<String ,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        //根据前端传递过来的用户名和密码 查询是否存在改用户
        TUser tUser = tUserMapper.selectUserByNameAndPsd(map);

        if (tUser == null){
            map.put("code",false);
        }else {
            map.put("code",true);
            map.put("user",tUser);
        }

        return map;
    }
}
