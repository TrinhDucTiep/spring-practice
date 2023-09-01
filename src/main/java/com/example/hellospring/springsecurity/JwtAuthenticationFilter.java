package com.example.hellospring.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Lấy từ request
            String jwt = getJwtFromRequest(httpServletRequest);
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                // Lấy user id
                Long userId = tokenProvider.getUserIdFromJWT(jwt);
                // Lấy UserDetail từ id
                UserDetails userDetails = customUserDetailService.loadUserById(userId);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    // phải set cái authentication cho SecurityContextHolder:
                    // vì nó giúp bạn quản lý thông tin xác thực của người dùng trong suốt quá trình xử lý yêu cầu HTTP.
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            logger.error("failed on set user authentication " + e);
        }
        // khi đã filter xong thì gọi doFilter để nó đi đến các filter tiếp theo
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem nó có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            /*
             nếu chuỗi JWT thật sự là "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
             thì khi đưa vào Header "Authorization", nó sẽ có dạng: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...".
             => nên ta phải loại bỏ 7 cái đầu tiên đi
             */
            return bearerToken.substring(7);
        }
        return null;
    }
}
