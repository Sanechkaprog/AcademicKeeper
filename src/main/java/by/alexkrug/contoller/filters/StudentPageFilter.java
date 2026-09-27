package by.alexkrug.contoller.filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/student")
public class StudentPageFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getSession().getAttribute("login") == null) {
            request.getRequestDispatcher("/error404.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
