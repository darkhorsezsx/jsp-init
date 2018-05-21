package com.zsx.demo.jsp;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This is {@link FooFilter}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Slf4j
public class FooFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("filter working for request with method: {}, path: {}", request.getMethod(), request.getServletPath());
    }

    @Override
    public void destroy() {

    }
}
