package com.whj.service;

import com.whj.pojo.Users;

import java.util.List;

public interface UsersService {
    Users login(String username, String userpwd);

    Integer addUsers(Users users);

    Users getByname(String username);

    List<Users> pageByClassid(Integer classid);

    Integer updateUsers(Users users);

    Users getByUserid(Integer userid);

    Integer delUserid(Integer userid);

    Integer delClassid(Integer classid);

    Integer updUserPwd(String userpwd,Integer userid);

    Integer getByNameId(String username);

    String getTrueName(String username);

    Integer getByClass(String username);
}
