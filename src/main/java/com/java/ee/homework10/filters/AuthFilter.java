package com.java.ee.homework10.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;


public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String password = req.getParameter("password_ui");
        String login = req.getParameter("login_ui");

        if (StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)) {

            //InputStream resourceAsStream = AuthFilter.class.getClassLoader().getResourceAsStream("test/users.properties");
            Properties properties = new Properties();

            //абсолютный путь !!!!!!!
            InputStream resourceAsStream = AuthFilter.class.getResourceAsStream("/test/users.properties");

            //относительный путь!!!!!!      такая же структура каталогов что и для AuthFilter!!!
            //InputStream resourceAsStream = AuthFilter.class.getResourceAsStream("com/filters/users.properties");

            properties.load(resourceAsStream);
            String adminLogin = properties.getProperty("login");
            String adminPassword = properties.getProperty("password");

            if (adminLogin.equals(login) && adminPassword.equals(password)) {
                chain.doFilter(req, resp);
            } else {
                errorMsg(resp, "You are not ADMIN!!");
            }

        } else {
            errorMsg(resp, "ERROR!!");
        }


    }

    private void errorMsg(ServletResponse resp, String x) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(x);
        writer.flush();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}