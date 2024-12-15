package com.nightlos.backendexp.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.nightlos.backendexp.component.JWTComponent;
import com.nightlos.backendexp.exception.Code;
import com.nightlos.backendexp.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final JWTComponent jwtComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler) throws Exception {
        String token = request.getHeader("token");
        if(token==null){
            throw XException.builder().code(Code.UNAUTHORIZED).build();
        }
        DecodedJWT decode=jwtComponent.decode(token);
        String uid=decode.getClaim("uid").asString();
        String role=decode.getClaim("role").asString();
        request.setAttribute("uid",uid);
        request.setAttribute("role",role);
        return true;
    }
}
