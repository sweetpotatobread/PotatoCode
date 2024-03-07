package com.haohao.books.servlet;

import com.haohao.books.bean.User;
import com.haohao.books.service.IUserService;
import com.haohao.books.service.impl.UserServiceImpl;
import com.haohao.books.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户管理的servlet类
 */

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    // 获取对应的service对象
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 针对POST提交的数据 在获取数据之前设置编码方式
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        if (type != null && !"".equals(type)){

            if (Constant.SERVLET_TYPE_SAVE.equals(type)){   // 添加用户信息
                saveUser(req, resp);

            }else if(Constant.SERVLET_TYPE_UPDATE.equals(type)){    // 更新用户信息

            }else if(Constant.SERVLET_TYPE_DELETE.equals(type)){    // 删除用户信息
                // 先获取用户id
                String id = req.getParameter("id");
                // 通过service层来处理删除操作
                Integer count = userService.deleteById(Integer.parseInt(id));
                // 重定向到查询用户操作
                resp.sendRedirect("/userServlet");
            }else if(Constant.SERVLET_TYPE_QUERY.equals(type)){     // 查询用户信息
                queryUser(req, resp);
            }
        } else {
            // 查询用户信息
            queryUser(req, resp);
        }
    }

    /**
     * 添加用户的方法
     * @param req
     * @param resp
     * @throws IOException
     */
    private void saveUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1.获取表单信息
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        user.setPhoneNum(req.getParameter("phoneNum"));
        user.setEmail(req.getParameter("email"));
        Integer count = userService.addUser(user);   //count表示插入的行数
        // 2.完成添加后的操作
        if(count > 0){
            // 添加成功，再做一次查询操作
            resp.sendRedirect("/userServlet");
        }else{
            System.out.println("添加失败...");
            // TODO 到失败页面
        }
    }

    // Fn+Alt+End+Enter 提取代码
    /**
     * 查询用户信息方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void queryUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.查询所有用户信息
        List<User> list = userService.getUser(null);
        // 2.把查询的数据封装到request作用域中
        req.setAttribute("list", list);
        // 3.跳转到user.jsp页面
        req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
    }
}
