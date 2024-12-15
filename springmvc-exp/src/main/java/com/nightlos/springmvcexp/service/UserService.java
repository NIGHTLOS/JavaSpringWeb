package com.nightlos.springmvcexp.service;

import com.nightlos.springmvcexp.dox.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<User> USERS = create();

    private static List<User> create(){
        User u = User.builder()
                .id("1")
                .name("me")
                .account("1001")
                .role(User.ADMIN)
                .password("$2a$10$dTrUsmnj8rS7FhFMu3kj2.Qnv/nY2eWhPMbARCh6PRFrE0x6SAylS")
                .build();
        User u2 = User.builder()
                .id("2")
                .name("lp")
                .account("2002")
                .role(User.USER)
                .password("$2a$10$dTrUsmnj8rS7FhFMu3kj2.Qnv/nY2eWhPMbARCh6PRFrE0x6SAylS")
                .build();
        return List.of(u,u2);
    }

    public List<User> listUsers() {
        return USERS;
    }

    public User getUserByAccount(String account) {
        return USERS.stream()
                .filter(u -> u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

}
