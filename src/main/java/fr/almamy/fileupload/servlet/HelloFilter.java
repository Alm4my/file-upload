package fr.almamy.fileupload.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "helloFilter", urlPatterns = "/helloServlet")
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("Executing doFilter method");
        log.info("Exec doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Done executing doFilter method");
        log.info("Done Executing doFilter()");
    }
}
