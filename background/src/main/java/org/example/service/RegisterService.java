package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.mappper.RegisterMapper;
import org.example.pojo.Register;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    //登录
    public Register login(String userName,String passWord){
        return registerMapper.login(userName, passWord);
    }

    //新增用户
    public int addUser(Register register){
        return registerMapper.addUser(register);
    }

    //根据id删除用户
    public int delteUser(Integer id){
        return registerMapper.delteUser(id);
    }
}
