package com.example.hellospring.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// một interface tiện ích của Spring Security giúp chúng ta cài đặt các thông tin dễ dàng hơn.
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // cung cấp thông tin user cho Spring Security
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // Tạo ra user trong bộ nhớ
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("tiep")
                        .password("tiep")
                        .roles("USER")
                        .build()
        );

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll() // cho phép tất cả mọi người truy cập vào đây
                .anyRequest().authenticated() // tất cả các request khác cần phải xác thực mới được truy cập
                .and()
            .formLogin() // cho phép người dùng xác thực bằng form login
                .defaultSuccessUrl("/hello").permitAll() // tất cả đều được truy cập vào địa chỉ này
                .and()
            .logout() // cho phép logout
                .permitAll();
    }
}
