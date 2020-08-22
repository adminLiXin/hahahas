package org.example.service;



import org.example.mappper.UserMapper;
import org.example.pojo.StudentInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentInfoService {

    @Resource
    private UserMapper userMapper;

    public List<StudentInfo> getStudentInfo(){
        return userMapper.getStudentInfo();

    }
}
