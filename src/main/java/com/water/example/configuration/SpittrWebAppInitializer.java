package com.water.example.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;

public class SpittrWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("webapp/uploads",2097152,4194304,0));

    }

    @Override
    protected Class<?>[] getRootConfigClasses() {//指定配置类
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {    //将ispatcherServlet映射到 "/"
        return new String[]{"/"};
    }
}
