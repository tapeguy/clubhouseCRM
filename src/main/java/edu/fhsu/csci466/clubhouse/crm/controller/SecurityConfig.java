package edu.fhsu.csci466.clubhouse.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private CrmAuthenticationProvider authProvider;

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http
            .authorizeRequests()
                .antMatchers( "/css/**", "/images/**", "/js/**" ).permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage( "/login.jsp" )
                .permitAll()
                .and()
            .logout()
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.authenticationProvider( authProvider );
    }
}
