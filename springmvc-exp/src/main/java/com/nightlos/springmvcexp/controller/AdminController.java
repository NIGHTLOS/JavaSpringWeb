package com.nightlos.springmvcexp.controller;


import com.nightlos.springmvcexp.service.UserService;
import com.nightlos.springmvcexp.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {
    private final UserService userService;

    @GetMapping("users")
    public ResultVO getUsers() {
        return ResultVO.success(userService.listUsers());
    }

    @GetMapping("users/{account}")
    public ResultVO getUser(@PathVariable String account) {
        return ResultVO.success(userService.getUserByAccount(account));
    }
}

