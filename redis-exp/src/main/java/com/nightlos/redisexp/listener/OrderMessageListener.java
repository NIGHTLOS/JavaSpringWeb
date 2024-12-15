package com.nightlos.redisexp.listener;

import com.nightlos.redisexp.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderMessageListener implements StreamListener<String, ObjectRecord<String,String>> {
    private final RedisTemplate<String, String> template;
    @Override
    public void onMessage(ObjectRecord<String, String> message) {
        log.info("{}",message.getId());
        log.info("{}",message.getValue());
        template.opsForStream().acknowledge(Order.GROUP_NAME, message);
    }


}
