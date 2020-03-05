package com.alisls.demo.spring.security.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring Security 的配置
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务，主要用来查询用户信息
     * @return UserDetailsService
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        // 基于内存的用户信息服务
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        UserDetails userAdmin = User.withUsername("admin").password("admin").authorities("p1").build();
        UserDetails userWangKe = User.withUsername("wangke").password("wangke").authorities("p2").build();
        inMemoryUserDetailsManager.createUser(userAdmin);
        inMemoryUserDetailsManager.createUser(userWangKe);

        return inMemoryUserDetailsManager;
    }

    /**
     * 定义密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // NoOpPasswordEncoder 为不加密认证
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 访问 /r/r1要有p1权限
                .antMatchers("/r/r1").hasAuthority("p1")
                // 访问 /r/r2要有p2权限
                .antMatchers("/r/r2").hasAuthority("p2")
                // 所有 /r/**的请求必须认证
                .antMatchers("/r/**").authenticated()
                // 其它的可以访问
                .anyRequest().permitAll()
                .and()
                // 允许表单登录
                .formLogin()
                // 登录成功转发地址
                .successForwardUrl("/login-success");
    }
}
