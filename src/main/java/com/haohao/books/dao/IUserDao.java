package com.haohao.books.dao;

import com.haohao.books.bean.User;

import java.util.List;

public interface IUserDao {
    /**
     * 用户dao层接口 查询用户信息
     * @param user
     * @return
     */
    public List<User> list(User user);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public Integer save(User user);

    /**
     * 真实删除用户信息
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);
}
