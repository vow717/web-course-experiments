package com.experiment5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.experiment5.entity.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/experiment5/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER=Logger.getLogger(LoginServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        User user = DatabaseUtils.getUser(username,pwd);
        String url;
        if (user != null) {
            req.getSession().setAttribute("user",user);
            req.getSession().removeAttribute("error");
            url="/experiment5/welcome";
        }else{
            req.getSession().setAttribute("error","用户名密码错误");
            url="/experiment5/login";
        }

        resp.sendRedirect(req.getContextPath()+url);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("/WEB-INF/jsp/E5/login.jsp").forward(req,resp);

    }
}
