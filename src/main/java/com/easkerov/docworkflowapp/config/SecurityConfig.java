package com.easkerov.docworkflowapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ivan").password("Welcome1").roles("USER");
        auth.inMemoryAuthentication().withUser("Admin").password("Welcome1").roles("ADMIN");
    }

    /**
     * Configure default users, roles and permissions
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/document/list/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .antMatchers("/document/add/**").access("hasRole('ROLE_USER')")
                .antMatchers("/document/delete/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/autherror.jsp");
    }

}
