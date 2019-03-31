package com.mc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName HttpFilter
 * @Author ZhengRongZe
 * @Date 2019/3/16 7:13
 **/
@WebFilter(urlPatterns = "/wechar", filterName = "myfilter")
public class HttpFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
//        servletRequest.setCharacterEncoding("UTF-8");
        HttpServletResponse servletResponse = (HttpServletResponse) response;
//        servletResponse.setCharacterEncoding("UTF-8");
//        String ip = servletRequest.getRemoteAddr();
//        String contextPath = servletRequest.getContextPath();
//        String authType = servletRequest.getAuthType();
//        Cookie[] cookies = servletRequest.getCookies();
//        Enumeration<String> headerNames = servletRequest.getHeaderNames();
//        String method = servletRequest.getMethod();
//        String pathInfo = servletRequest.getPathInfo();
//        String servletPath = servletRequest.getServletPath();
//        String url = servletRequest.getRequestURI();
//        System.out.println("ip = " + ip);
//        System.out.println("contextPath = " + contextPath);
//        System.out.println("authType = " + authType);
//        System.out.println("cookies = " + cookies);
//        System.out.println("headerNames = " + headerNames);
//        System.out.println("method  = " + method);
//        System.out.println("servletPath = " + servletPath);
//        System.out.println("url = " + url);

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
