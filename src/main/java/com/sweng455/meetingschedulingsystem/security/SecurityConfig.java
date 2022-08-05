package com.sweng455.meetingschedulingsystem.security;

import com.sweng455.meetingschedulingsystem.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_URL = "/logout";
    private static final String LOGOUT_SUCCESS_URL = "/";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Set default security policy that permits Vaadin internal requests and
        // denies all other
        super.configure(http);
        /*
        http.oauth2Login().loginPage(LOGIN_URL).permitAll()
                .and()
                .formLogin().loginPage(LOGIN_URL).permitAll().loginProcessingUrl(LOGIN_URL).failureUrl(LOGIN_URL)
                .and()
                .logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
         */

        setLoginView(http, LoginView.class, "/logout");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // For testing use only
        auth.inMemoryAuthentication().withUser("user").password("{noop}userpass").roles("USER");
        // For testing use only
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}
