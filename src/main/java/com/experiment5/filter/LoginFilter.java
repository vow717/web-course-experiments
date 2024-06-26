package com.experiment5.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.experiment5.entity.User;
import java.io.IOException;
import java.util.List;

@WebFilter("/experiment5/*")
public class LoginFilter extends HttpFilter {
    private final List<String>excludedUrls=List.of("/experiment5/login");
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res ,FilterChain chain)throws IOException, ServletException {
        System.out.println("Filter is working!"); // 添加日志输出
        for(String url:excludedUrls){
            if(req.getServletPath().equals(url)){
                chain.doFilter(req,res);
                return;
            }
        }
        User user=(User)req.getSession().getAttribute("user");
        if(user==null){
            req.getSession().setAttribute("error","！！！！请先登入！！！！");
            res.sendRedirect(req.getContextPath()+"/experiment5/login");
            return;
        }
        chain.doFilter(req,res);
    }
}
