package com.nightlos.jdbcexp.repository;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dox.User;
import com.nightlos.jdbcexp.dto.UserAddressDTO;
import com.nightlos.jdbcexp.dto.UserCountDTO;
import com.nightlos.jdbcexp.mapper.UserExtractor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        var user = User.builder()
                .name("liupeng")
                .build();
        userRepository.save(user);
    }

    @Test
    void findByUserId() {
        UserAddressDTO byUserId = userRepository.findByUserId("1296859193107865600");
        for(Address address:byUserId.getAddresses()){
            log.debug(address.toString());
        }
    }

    @Test
    void findCount() {
        for(UserCountDTO count : userRepository.findCount()){
            log.debug(count.toString());
        }
    }
}