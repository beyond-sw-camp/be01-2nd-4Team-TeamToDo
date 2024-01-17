package com.todo.security.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//import com.todo.security.filter.JwtTokenFilter;
import com.todo.security.service.UserService;
import com.todo.security.userrole.UserRole;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;
    private static String secretKey = "my-secret-key-123123";
    private final AuthenticationProvider authenticationProvider;
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .requestMatchers("/jwt-login/info").authenticated()
                .requestMatchers("/jwt-login/admin/**").hasAuthority(UserRole.ADMIN.name())
                .and().build();
    }
    
    
}