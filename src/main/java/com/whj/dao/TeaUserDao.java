package com.whj.dao;

import com.whj.pojo.TeaUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeaUserDao {
    TeaUser teaLogin(String username, String userpwd);

    // 获取教师姓名
    String getTeaUsername(String username);

    // 获取班级id
    Integer getClassId(String username);

    // 获取教师id
    Integer getTeacherId(String username);
}
