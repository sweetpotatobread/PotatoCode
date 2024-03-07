package com.haohao.books.service;

import com.haohao.books.bean.User;

import java.util.List;

/**
 * 用户的service层接口
 */

public interface IUserService {

    /**
     * 获取所有用户信息
     * @param user
     * @return
     */
    public List<User> getUser(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public Integer addUser(User user);

    public Integer deleteById(Integer id);
}
