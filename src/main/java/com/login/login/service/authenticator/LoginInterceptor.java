// LoginInterceptor.java
package com.login.login.service.authenticator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.login.login.service.CookieService;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        if(CookieService.getCookie(request, "usuarioNome") != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}