package com.ashin.service.config;//package com.debug.springboot.server.config;
//
//import com.debug.springboot.server.security.UserPasswordEncoder;
//import com.debug.springboot.server.security.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
///**
// * @Author:debug (SteadyJack)
// * @Link: weixin-> debug0868 qq-> 1948831260
// * @Date: 2019/11/10 23:16
// **/
//@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//    //TODO:用户身份认证
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserService())
//                .passwordEncoder(new UserPasswordEncoder());
//    }
//
//    //TODO:HTTP请求URL 接口拦截
//    @Override
//    /*protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().and()
//                .authorizeRequests()
//                .antMatchers("/security/info*//**")
//                .authenticated()
//                .anyRequest()
//                .permitAll();
//    }*/
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and()
//                //.userDetailsService(new UserService())
//
//
//                .authorizeRequests()
//                .antMatchers("/security/info/**")
//                .authenticated()
//                .anyRequest()
//                .permitAll();
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
