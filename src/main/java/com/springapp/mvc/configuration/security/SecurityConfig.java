package com.springapp.mvc.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Anton on 18.02.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)/*.passwordEncoder(passwordEncoder())*/;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
               .authorizeRequests()
                .antMatchers("/", "/login","/registration/").permitAll()
                .antMatchers("/main/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_CLIENT')")
                .antMatchers("/main/**").access("hasRole('ROLE_ADMIN')")
//               .anyRequest().authenticated()

               .and().formLogin().loginPage("/")
               .defaultSuccessUrl("/main/")
                .failureUrl("/")
                .usernameParameter("email_user")
                .passwordParameter("user_password")
                .and().logout().logoutSuccessUrl("/")
//                .deleteCookies()
                .and().csrf();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
