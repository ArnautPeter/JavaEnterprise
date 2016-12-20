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
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/users")
public class ValidationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (isNotEmptyParameters(servletRequest)) {
            if (isParametersAreValid(servletRequest))
                filterChain.doFilter(servletRequest, servletResponse);
            else errorMsg(servletResponse, "Pls input valid values");
        } else
            errorMsg(servletResponse, "Pls input all values");
    }

    public void destroy() {
    }


    private void errorMsg(ServletResponse resp, String x) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(x);
        writer.flush();
    }

    private boolean isNotEmptyParameters(ServletRequest servletRequest) {
        String login = servletRequest.getParameter("login_ui");
        String password = servletRequest.getParameter("password_ui");
        String age = servletRequest.getParameter("age_ui");
        String phone = servletRequest.getParameter("phone_ui");
        String email = servletRequest.getParameter("email_ui");
        String address = servletRequest.getParameter("address_ui");

        return StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)
                && StringUtils.isNotEmpty(age) && StringUtils.isNotEmpty(phone)
                && StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(address);
    }

    private boolean isParametersAreValid(ServletRequest servletRequest) {
        String phone = servletRequest.getParameter("phone_ui");
        String email = servletRequest.getParameter("email_ui");

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher emailMatcher = p.matcher(email);
        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        Matcher phoneMatcher = pattern.matcher(phone);
        return emailMatcher.matches() && phoneMatcher.matches();

    }
}