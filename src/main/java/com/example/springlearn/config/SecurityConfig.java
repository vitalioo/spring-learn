package com.example.springlearn.config;

import com.example.springlearn.security.AuthProviderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthProviderImpl authProvider;

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}
