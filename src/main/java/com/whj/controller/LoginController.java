package com.whj.controller;

import com.whj.pojo.TeaUser;
import com.whj.pojo.Users;
import com.whj.service.TeaUserService;
import com.whj.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    UsersService usersService;
    @Autowired
    TeaUserService teaUserService;

    //教师登录与学生登录的互相跳转
    @GetMapping("toTeacher")
    public String toTeaLogin(){
        return "teacher/login";
    }
    @GetMapping("toStuLogin")
    public String toStuLogin(){
        return "student/login";
    }

    //学生登录
    @PostMapping("/stulogin")
    public String stulogin(String username, String userpwd, HttpServletRequest servletRequest){
        Users login = usersService.login(username, userpwd);

        if(login==null){
            System.out.println("登录失败！");
            servletRequest.getSession().setAttribute("mag","密码错误");
            return "redirect:/toStuLogin";
        }else{
            Integer userId = usersService.getByNameId(username);
            String trueName = usersService.getTrueName(username);
            Integer byClass = usersService.getByClass(username);
            System.out.println("登录成功！");
            servletRequest.getSession().setAttribute("liss",userpwd);
            servletRequest.getSession().setAttribute("truename",trueName);
            servletRequest.getSession().setAttribute("lis",userId);
            servletRequest.getSession().setAttribute("classid",byClass);
            return "/student/StuMan";
        }
    }

    //教师登录
    @PostMapping("/tealogin")
    public String teaLogin(String username, String userpwd, HttpServletRequest request){
        // 查询班级id
        Integer classId = teaUserService.getClassId(username);
        // 获取教师id
        Integer teacherId = teaUserService.getTeacherId(username);

        TeaUser teaUser = teaUserService.teaLogin(username, userpwd);
        if(teaUser==null){
            request.getSession().setAttribute("msg","登录密码错误！");
            return "redirect:/toTeacher";
        }else{
            String teaUsername = teaUserService.getTeaUsername(username);
            request.getSession().setAttribute("Teatruename",teaUsername);
            request.getSession().setAttribute("TeaClassid",classId);
            request.getSession().setAttribute("Teauserid",teacherId);
            return "teacher/manage";
        }
    }
}
