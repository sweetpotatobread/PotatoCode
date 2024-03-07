package com.whj.service;

import com.whj.pojo.TeaUser;

public interface TeaUserService {
    TeaUser teaLogin(String username, String userpwd);

    String getTeaUsername(String username);

    Integer getClassId(String username);

    Integer getTeacherId(String username);
}
