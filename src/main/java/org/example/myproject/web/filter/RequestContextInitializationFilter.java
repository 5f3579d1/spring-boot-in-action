package org.example.myproject.web.filter;

import org.example.myproject.util.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by k on 9/28/15.
 */
@Component
public class RequestContextInitializationFilter extends GenericFilterBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("> doFilter");

        logger.info("Context Path: " + request.getServletContext().getContextPath());

        logger.info("Request Parameter Map: " + String.valueOf(request.getParameterMap()));

        RequestContext.init();

        chain.doFilter(request, response);
        logger.debug("< doFilter");
    }

}
