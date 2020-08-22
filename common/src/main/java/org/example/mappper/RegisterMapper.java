package org.example.mappper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Register;

@Mapper
public interface RegisterMapper {
    //登录
    public Register login(@Param("userName") String userName, @Param("passWord") String passWord);

    //新增用户
    public int addUser(Register register);
    //根据id删除用户
    public int delteUser(@Param("id") Integer id);
}
