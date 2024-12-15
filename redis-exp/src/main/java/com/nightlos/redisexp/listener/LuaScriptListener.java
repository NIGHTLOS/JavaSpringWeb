package com.nightlos.redisexp.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class LuaScriptListener {
    private final RedissonClient client;
    @Value("mylib.lua")
    private Resource resource;

    @EventListener(ApplicationReadyEvent.class)
    public void listen() throws IOException {
        String contentAsString = resource.getContentAsString(Charset.defaultCharset());
        client.getFunction()
                .loadAndReplace("mylib_0",contentAsString);
    }
}
