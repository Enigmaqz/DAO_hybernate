package ru.netology;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("000000"))
                .authorities("admin")
                .and()
                .withUser("User")
                .password(encoder().encode("111111"))
                .authorities("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/persons/by-name-surname").hasAnyAuthority("admin")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/persons/by-city").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();
    }

}
