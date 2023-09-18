package com.example.mvcpractice.mvc;

import com.example.mvcpractice.mvc.controller.Controller;
import com.example.mvcpractice.mvc.controller.RequestMethod;
import com.example.mvcpractice.mvc.view.JspViewResolver;
import com.example.mvcpractice.mvc.view.View;
import com.example.mvcpractice.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started. ");

        try {
            Controller handler = requestMappingHandlerMapping.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            String viewName = handler.handleRequest(request, response);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveViewName(viewName);
                view.render(new HashMap<>(), request, response);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }

    }
}
