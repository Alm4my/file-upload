package fr.almamy.fileupload;

import fr.almamy.fileupload.servlet.HelloFilter;
import fr.almamy.fileupload.servlet.HelloListener;
import fr.almamy.fileupload.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }

    /// Register Servlet
    @Bean
    public ServletRegistrationBean<HelloServlet> getServletRegistrationBean(){
        var servletBean = new ServletRegistrationBean<>(new HelloServlet());
        servletBean.addUrlMappings("/helloServlet");
        return servletBean;
    }

    /// Register Filter
    @Bean
    public FilterRegistrationBean<HelloFilter> getFilterRegistrationBean() {
        var filterBean = new FilterRegistrationBean<>(new HelloFilter());
        // Add filter path
        filterBean.addUrlPatterns("/helloServlet");
        return filterBean;
    }

    /// Register Listener
    @Bean
    public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<>(new HelloListener());
    }


}
