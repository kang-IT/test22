package com.itheima.web.servlet;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class Userservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
        //3.封装user对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);
        //4.调用UserService的find方法
        UserService service = new UserServiceImpl();
        User user1 = service.find(user);
        System.out.println(user1);

        //5.判断user
        if(user1 == null){
            //登录失败
            System.out.println("失败");
            resp.sendRedirect("/error.html");

        }else{
            //登录成功
            //存储数据
            //转发
            System.out.println("成功");
            req.getSession().setAttribute("user",user1);
            resp.sendRedirect("/success.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
