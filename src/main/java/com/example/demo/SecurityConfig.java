package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Autowired
   UserDetailAuth userDetailAuth;
    
   @Bean
   public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{

      http
         .csrf(customizer -> customizer.disable())
         .authorizeHttpRequests(request -> request.requestMatchers("/person/signIn").permitAll().anyRequest().authenticated())
         .httpBasic(Customizer.withDefaults())
         .formLogin(Customizer.withDefaults())
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return http.build();
   }

   @Bean 
   public AuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
      provider.setUserDetailsService(userDetailAuth);
      provider.setPasswordEncoder(passwordEncoder());   
      return provider;
   }
   
   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
   }
   
}
