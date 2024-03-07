package com.whj.service.impl;

import com.whj.dao.TeaUserDao;
import com.whj.dao.UsersDao;
import com.whj.pojo.TeaUser;
import com.whj.service.TeaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaUserServiceImpl implements TeaUserService {
    @Autowired
    TeaUserDao teaUserDao;
    @Override
    public TeaUser teaLogin(String username, String userpwd) {
        return teaUserDao.teaLogin(username, userpwd);
    }

    @Override
    public String getTeaUsername(String username) {
        return teaUserDao.getTeaUsername(username);
    }

    @Override
    public Integer getClassId(String username) {
        return teaUserDao.getClassId(username);
    }

    @Override
    public Integer getTeacherId(String username) {
        return teaUserDao.getTeacherId(username);
    }


}
