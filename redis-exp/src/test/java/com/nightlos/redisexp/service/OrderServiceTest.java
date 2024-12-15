package com.nightlos.redisexp.service;

import com.nightlos.redisexp.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void addItems() {
        List<Item> items = List.of(
                Item.builder().id("01JCJ5EJGH7K2W7XHPNQYWP7AA").total(30).build(),
                Item.builder().id("01JCJ5EJGJ3TM22S6P3T4CD30S").total(30).build()
        );
        orderService.addItems(items);
    }

    @Test
    void buy() throws InterruptedException {
        var count = 200;
        CountDownLatch latch = new CountDownLatch(count);
        var random = new Random();
        for(int i=0;i<200;i++){
            Thread.startVirtualThread(()->{
                long buy = orderService.buy("01JCJ5EJGH7K2W7XHPNQYWP7AA",
                        String.valueOf(random.nextInt(count)));
                log.debug("{}",buy);
                latch.countDown();
            });
        }
        latch.await();
        Thread.sleep(6000);
    }
}