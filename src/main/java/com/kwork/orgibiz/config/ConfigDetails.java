package com.kwork.orgibiz.config;

import com.kwork.orgibiz.repository.AccessRepository;
import com.kwork.orgibiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class ConfigDetails {

    private final UserRepository userRepository;
    private final AccessRepository accessRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            var user = userRepository.findByEmail(username);
            if(user == null){
                throw new UsernameNotFoundException("Пользователь не найден");
            }else return user;
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());

        http.csrf(AbstractHttpConfigurer::disable);

        http.exceptionHandling(eh -> eh.accessDeniedPage("/forbidden"));

        http.formLogin(f -> {
            f.loginProcessingUrl("/auth")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginPage("/sign-in")
                    .defaultSuccessUrl("/",true)
                    .failureUrl("/sign-in?error");
        });

        http.logout(l-> l.logoutUrl("/log-out").logoutSuccessUrl("/sign-in"));

        return http.build();
    }
}
