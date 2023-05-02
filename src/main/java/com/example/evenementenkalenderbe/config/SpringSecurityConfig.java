package com.example.evenementenkalenderbe.config;

import com.example.evenementenkalenderbe.filter.JwtRequestFilter;
import com.example.evenementenkalenderbe.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }


    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .httpBasic().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ADMIN", "USER", "CREATOR")
                .requestMatchers(HttpMethod.POST, "/users/**").hasAnyAuthority("ADMIN", "CREATOR")
                .requestMatchers(HttpMethod.PUT, "/users/**").hasAnyAuthority("ADMIN", "CREATOR", "USER")
                .requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("ADMIN", "CREATOR")
                .requestMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ADMIN", "CREATOR", "USER")
                .requestMatchers(HttpMethod.GET, "/events").permitAll()
                .requestMatchers(HttpMethod.POST, "/events").hasAnyAuthority("CREATOR", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/events/**").hasAnyAuthority("ADMIN", "CREATOR")
                .requestMatchers(HttpMethod.GET, "/events/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/events/**").hasAnyAuthority("CREATOR", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/events/**").hasAnyAuthority("CREATOR", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/events/**").hasAnyAuthority("ADMIN", "CREATOR")
                .requestMatchers(HttpMethod.POST, "/upload/**").hasAnyAuthority("CREATOR", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/{id}/upload/**").hasAnyAuthority("CREATOR", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/download/**").permitAll()
                .requestMatchers("/authenticated").authenticated()
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().denyAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}

