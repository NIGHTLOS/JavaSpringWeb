package com.nightlos.redisexp.componet;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ULIDTest {
    @Autowired
    private ULID ulid;

    @Test
    void nextULID() {
        //01JCJ5EJGH7K2W7XHPNQYWP7AA
        log.info(ulid.nextULID());
        //01JCJ5EJGJ3TM22S6P3T4CD30S
        log.info(ulid.nextULID());
        //01JCJ5EJGJWZ11CGANSH14D8K6
        log.info(ulid.nextULID());
    }
}