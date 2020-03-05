package com.alisls.demo.spring.security.init;

import com.alisls.demo.spring.security.config.ApplicationConfig;
import com.alisls.demo.spring.security.config.WebConfig;
import com.alisls.demo.spring.security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载Spring容器
 */
public class SpringApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 相当于加载applicationContext.xml
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ApplicationConfig.class, WebSecurityConfig.class};
    }

    /**
     * 相当于加载springmvc.xml
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    /**
     * url-mapping
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
