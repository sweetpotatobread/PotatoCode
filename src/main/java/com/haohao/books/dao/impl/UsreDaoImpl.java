package com.haohao.books.dao.impl;

import com.haohao.books.bean.User;
import com.haohao.books.dao.IUserDao;
import com.haohao.books.utils.DelFlagE;
import com.haohao.books.utils.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户持久层实现类
 */

public class UsreDaoImpl implements IUserDao {
    @Override
    public List<User> list(User user) {
        // 1.获取QueryRunner
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        // 2.构建SQL语言
        String sql = "select * from t_user where is_deleted=?";
        List<User> list = null;
        try {
            // list = queryRunner.query(sql, new BeanListHandler<User>(User.class));
            // DBUtils不会帮助我们完成驼峰命名的转换，如果字段和属性不一致的话，我们还不能使用这种方式
            list = queryRunner.query(sql, new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet resultSet) throws SQLException {
                    List<User> list = new ArrayList<>();
                    while (resultSet.next()) {
                        // 每条记录对应一个User对象
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setUserName(resultSet.getString("user_name"));
                        user.setPassword(resultSet.getString("password"));
                        user.setPhoneNum(resultSet.getString("phone_num"));
                        user.setEmail(resultSet.getString("email"));
                        user.setIsDeleted(resultSet.getInt("is_deleted"));
                        user.setSalt(resultSet.getString("salt"));
                        list.add(user); // 把封装好数据的User对象添加到List集合中
                    }
                    return list;
                }
            },DelFlagE.NO.code);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 添加用户信息的方法
     * @param user
     * @return
     */
    @Override
    public Integer save(User user) {
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        String sql = "insert into t_user(user_name,password,phone_num,email,salt)values(?,?,?,?,?)";
        try {
            return queryRunner.update(sql,
                    user.getUserName(),
                    user.getPassword(),
                    user.getPhoneNum(),
                    user.getEmail(),
                    user.getSalt());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;   // 返回0说明插入失败
    }

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        // String sql = "delete from t_user where id=?"; // 物理删除
        String sql = "update t_user set is_deleted=? where id=?";
        try {
            return queryRunner.update(sql, DelFlagE.YES.code, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        UsreDaoImpl dao = new UsreDaoImpl();
        for (User user : dao.list(null)) {
            System.out.println(user);
        }
    }
}
