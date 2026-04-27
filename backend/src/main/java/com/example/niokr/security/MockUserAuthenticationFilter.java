package com.example.niokr.security;

import com.example.niokr.model.User;
import com.example.niokr.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class MockUserAuthenticationFilter extends OncePerRequestFilter {

    public static final String HEADER_NAME = "X-User-Id";

    private final UserService userService;

    public MockUserAuthenticationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String headerValue = request.getHeader(HEADER_NAME);

        if (headerValue != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                Long userId = Long.parseLong(headerValue);
                userService.findById(userId).ifPresent(user -> {
                    var authorities = user.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
                            .collect(Collectors.toSet());
                    var auth = new UsernamePasswordAuthenticationToken(user, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                });
            } catch (NumberFormatException ignored) {
                // invalid header value, ignore authentication
            }
        }

        filterChain.doFilter(request, response);
    }
}
