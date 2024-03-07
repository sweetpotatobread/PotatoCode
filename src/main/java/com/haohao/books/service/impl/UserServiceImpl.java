package com.haohao.books.service.impl;

import com.haohao.books.bean.User;
import com.haohao.books.dao.IUserDao;
import com.haohao.books.dao.impl.UsreDaoImpl;
import com.haohao.books.service.IUserService;

import java.util.List;

/**
 * 用户service层接口实现类
 */

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UsreDaoImpl();

    @Override
    public List<User> getUser(User user) {

        return userDao.list(user);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userDao.deleteById(id);
    }
}
