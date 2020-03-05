package com.alisls.demo.spring.security.init;

import com.alisls.demo.spring.security.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityApplicationInitializer() {
        // super(WebSecurityConfig.class);
    }

}
