package com.nightlos.springmvcexp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoding() {
        String rawPassword = "123456";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        // 输出加密后的密码
        System.out.println("Encoded password: " + encodedPassword);
    }
}
