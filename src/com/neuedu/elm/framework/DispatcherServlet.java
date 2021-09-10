package com.neuedu.elm.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

//前端控制器类，接受所有请求
//路径格式，/类名/方法名
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集和内容类型
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //2、获取请求路径(/LoginController/login)，截取字符串取得类名和方法名
        String path = req.getServletPath();
        String className = path.substring(1, path.lastIndexOf("/"));
        String methodName = path.substring( path.lastIndexOf("/") + 1);
        PrintWriter out = null;

        try {
            //3、创建类对象，通过反射机制执行对象的方法
            Class clazz = Class.forName("com.neuedu.elm.controller." + className);
            //创建controller类的对象
            Object controller = clazz.newInstance();
            //获取对象的方法
            Method method = clazz.getMethod(methodName, new Class[]{HttpServletRequest.class,HttpServletResponse.class});
            //执行该方法
            Object result = method.invoke(controller, new Object[]{req,resp});
            //4、把结果输出为json字符串
            out = resp.getWriter();
            ObjectMapper om = new ObjectMapper();
            out.print(om.writeValueAsString(result));


        } catch (Exception e) {
            System.out.println("--DispatcherServlet信息：请求url：" + path);
            e.printStackTrace();
        } finally {
            out.close();
        }


    }
}
