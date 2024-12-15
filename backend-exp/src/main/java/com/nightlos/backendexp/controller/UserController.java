package com.nightlos.backendexp.controller;

import com.nightlos.backendexp.dox.User;
import com.nightlos.backendexp.service.UserService;
import com.nightlos.backendexp.vo.ResultVO;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("password")
    public ResultVO patchPassword(@RequestBody User user, @RequestAttribute("uid") String uid) {
        userService.updateUserPassword(uid,user.getPassword());
        return ResultVO.ok();
    }
}
