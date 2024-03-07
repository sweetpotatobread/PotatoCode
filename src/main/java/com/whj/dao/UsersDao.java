package com.whj.dao;
import com.whj.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UsersDao {
    Users login(String username, String userpwd);

    Integer addUsers(Users users);

    Users getByname(String username);

    List<Users> pageById(Integer classid);

    Integer updateUsers(Users users);

    Users getByUserid(Integer userid);

    Integer delUserid(Integer userid);

    Integer delClassid(Integer classid);

    // 修改密码
    Integer updUserPwd(String userpwd,Integer userid);
    // 通过用户名查找用户id
    Integer getByNameId(String username);

    // 通过用户名查找学生真实姓名
    String getTrueName(String username);

    // 通过用户名查询班级id
    Integer getByClass(String username);

    // 查询所有学生id
    List<Users> getUserid(Integer classid);
}
