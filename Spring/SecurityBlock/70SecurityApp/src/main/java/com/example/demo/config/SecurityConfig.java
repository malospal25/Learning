package com.example.demo.config;

import com.example.demo.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //отключаем защиту от межсайтовой подделки запросов (Временно отключаем отправку токена)
                .authorizeRequests()    // Все запросы которые приходят в приложение теперь будут проходить авторизацию
                .antMatchers("/auth/login", "/error").permitAll() // Какой запрос пришел в наше приложение (не аутентифицированного пользователя мы дожны перенаправлять на данную страницу, а так же мы допускаем любого пользователя на страницу с ошибками)
                .anyRequest().authenticated() // Мы должны указать, что на остальные страницы не пускаем не аутентифицированного пользователя
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/process_login")
                .failureUrl("/auth/login?error");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
