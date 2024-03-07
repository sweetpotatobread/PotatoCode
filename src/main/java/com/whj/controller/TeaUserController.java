package com.whj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeaUserController {
    // 退出登录
    @GetMapping("/Tlogout")
    public String Tlogout(HttpServletRequest request){
        request.getSession().removeAttribute("Teauserid");
        request.getSession().removeAttribute("TeaClassid");
        request.getSession().removeAttribute("Teatruename");
        return "redirect:/toTeacher";
    }
}
