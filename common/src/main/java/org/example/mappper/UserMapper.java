package org.example.mappper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.StudentInfo;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<StudentInfo> getStudentInfo();

}
