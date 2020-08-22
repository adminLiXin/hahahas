package org.example.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.example.pojo.Register;
import org.example.pojo.StudentInfo;
import org.example.service.RegisterService;
import org.example.service.StudentInfoService;
import org.example.vo.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;

@RestController
@Api(value = "用户管理控制器")
public class UserController {

    @Autowired
    private StudentInfoService studentInfoService;

    @Resource
    private RegisterService registerService;


    /*
    @ApiOperation(value = "获取所有的用户信息")
    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    public ResponseDate<List<StudentInfo>> getUser(){
        ResponseDate responseDate =new ResponseDate<List<StudentInfo>>();
        try {
            List<StudentInfo> studentInfos =studentInfoService.getStudentInfo();
            responseDate.setStatus(200);
            responseDate.setMessage("查询成功");
            responseDate.setDate(studentInfos);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseDate;
    }

     */

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value = "用户名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="passWord",value = "密码",dataType = "String",paramType = "query")
    })
    public ResponseDate<Register> login(String userName,String passWord){
        ResponseDate responseDate = new ResponseDate();
        try {
            Register register = registerService.login(userName,passWord);
            responseDate.setStatus(200);
            responseDate.setMessage("登录成功！");
            responseDate.setDate(register);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseDate;
    }

    @ApiOperation(value = "根据id号删除用户")
    @RequestMapping(value = "delteUser",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "ID号",dataType = "int",paramType = "query")
    })
    public ResponseDate<Register> delteUser(Integer id){
        ResponseDate responseDate = new ResponseDate();
        if(registerService.delteUser(id) >0){
            responseDate.setStatus(200);
            responseDate.setMessage("用户已删除！");
        }else{
            responseDate.setStatus(500);
            responseDate.setMessage("用户不存在！");
        }
        return responseDate;
    }
}
