package com.springapp.mvc.configuration.application;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Anton on 06.03.2016.
 */
public class initialization  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


   /* @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = {new CORSFilter()};
        return singleton;
    }*/
}
