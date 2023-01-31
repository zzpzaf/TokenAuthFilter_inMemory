package com.zzpzaf.restapidemo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {

   
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CustomRequestHeaderTokenFilter customFilter() throws Exception {
        return new CustomRequestHeaderTokenFilter(authManager());
    }

    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .exceptionHandling()
             .authenticationEntryPoint((request, response, authEx) -> {
                                         response.setHeader("WWW-Authenticate", "Basic realm=\"Access to /signin authentication endpoint\"");
                                         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                                         response.getWriter().write("{ \"Error\": \"" + authEx.getMessage() + " - You are not authenticated.\" }");
                                     })
            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                                                     .requestMatchers(HttpMethod.GET, "/auth/signin").authenticated())

            .authorizeHttpRequests(authorize -> authorize.requestMatchers("/users").hasRole("ADMIN")
                                                     .requestMatchers("/items").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            )
            ;
        http.addFilterBefore( customFilter(), UsernamePasswordAuthenticationFilter.class); 
        return http.build();
    } 


}

