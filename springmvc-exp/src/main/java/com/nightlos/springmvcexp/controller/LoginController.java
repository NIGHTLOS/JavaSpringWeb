package com.nightlos.springmvcexp.controller;

import com.nightlos.springmvcexp.component.JWTComponent;
import com.nightlos.springmvcexp.service.UserService;
import com.nightlos.springmvcexp.dox.User;
import com.nightlos.springmvcexp.exception.Code;
import com.nightlos.springmvcexp.vo.ResultVO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response) {
        User userR=userService.getUserByAccount(user.getAccount());
        if(userR==null || !passwordEncoder.matches(user.getPassword(),userR.getPassword())) {
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        String token=jwtComponent.encode(Map.of("uid",userR.getId(),"role",userR.getRole()));
        response.setHeader("token",token);
        response.setHeader("role",userR.getRole());
        return ResultVO.success(userR);
    }
}
