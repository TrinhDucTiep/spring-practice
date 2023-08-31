package com.example.hellospring.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Khi người dùng đăng nhập thì Spring Security sẽ cần lấy các thông tin UserDetails hiện có để kiểm tra.
// Vì vậy, bạn cần tạo ra một class kế thừa lớp UserDetailsService mà Spring Security cung cấp để làm nhiệm vụ này.
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserSecurity userSecurity = userSecurityRepository.findByUsername(s);
        if (userSecurity == null) throw new UsernameNotFoundException(s);
        return new CustomUserDetails(userSecurity);
    }
}
