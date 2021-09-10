package com.neuedu.elm.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CORSFilter implements Filter {
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse responce, FilterChain chain) throws ServletException, IOException {

        //设置服务器端允许跨域访问,允许跨域发送cookie
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)responce;
        //设置允许跨域，开启cookie
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        resp.setHeader("Access-Control-Max-Age", "3628800");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        chain.doFilter(request, responce);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
