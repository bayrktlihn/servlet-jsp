package io.bayrktlihn.bookstorewebsite.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/admin/*", filterName = "filter2")
public class AdminLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(false);

        String contextPath = httpServletRequest.getContextPath();
        List<String> permittedUrls = Arrays.asList(contextPath +"/admin/login.jsp", contextPath+"/admin/login", contextPath+"/admin/logout");

        String requestURI = httpServletRequest.getRequestURI();

        if (permittedUrls.stream().anyMatch(item -> item.equals(requestURI))) {
            chain.doFilter(request, response);
        } else {
            if(session == null || session.getAttribute("username") == null){
                httpServletResponse.sendRedirect("/admin/login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }



    }
}
