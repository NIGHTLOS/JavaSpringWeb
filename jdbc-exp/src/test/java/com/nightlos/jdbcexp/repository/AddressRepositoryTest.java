package com.nightlos.jdbcexp.repository;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dto.AdderssUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
    void findByUserId() {
        for(Address address:addressRepository.findByUserId("1296859193107865600")){
            log.debug("address: {}", address);
        }
    }

    @Test
    void findByAId() {
        AdderssUserDTO adderssUserDTO=addressRepository.findByAId("1");
        log.debug("user: {}", adderssUserDTO.getUser());
        log.debug("address: {}", adderssUserDTO.getAddress());
    }
}