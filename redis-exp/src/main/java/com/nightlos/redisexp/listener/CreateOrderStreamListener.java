package com.nightlos.redisexp.listener;


import com.nightlos.redisexp.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.stream.StreamCreateGroupArgs;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CreateOrderStreamListener {
    private final RedissonClient client;


    @EventListener(ApplicationReadyEvent.class)
    public void listen() {
        RStream<String,String> stream = client.getStream(Order.STREAM_KEY);
        if(!stream.isExists()){
            stream.createGroup(StreamCreateGroupArgs
                    .name(Order.GROUP_NAME)
                    .makeStream());
            stream.createConsumer(Order.GROUP_NAME,Order.GROUP_CONSUMER);
        }
    }

}
