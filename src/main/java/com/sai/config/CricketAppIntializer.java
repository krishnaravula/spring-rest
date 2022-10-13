package com.sai.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CricketAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {


            Class[] cricketAppConfigClass = {CricketAppConfig.class};

        return cricketAppConfigClass;
    }

    protected String[] getServletMappings() {
        String myMappings[] ={"/"};
        return myMappings;
    }
}
