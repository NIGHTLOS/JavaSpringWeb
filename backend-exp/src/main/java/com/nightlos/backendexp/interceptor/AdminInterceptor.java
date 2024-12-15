package com.nightlos.backendexp.interceptor;

import com.nightlos.backendexp.dox.User;
import com.nightlos.backendexp.exception.Code;
import com.nightlos.backendexp.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler) throws Exception {
        if(User.ADMIN.equals(request.getAttribute("role"))){
            return true;
        }
        throw XException.builder().code(Code.FORBIDDEN).build();
    }
}
