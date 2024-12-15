package com.nightlos.redisexp.service;


import com.nightlos.redisexp.componet.ULID;
import com.nightlos.redisexp.dto.Item;
import com.nightlos.redisexp.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final RedissonClient client;
    private final ULID ulid;

    public void addItems(List<Item> items){
        RBatch batch = client.createBatch();
        for(Item item : items){
            RMapAsync<String,Integer> map = batch.getMap(Item.PER_KEY+item.getId(),
                    StringCodec.INSTANCE);
            map.putAsync("total",item.getTotal());
        }
        batch.execute();
    }

    public long buy(String itemId,String userId){
        long q = client.getFunction()
                .call(FunctionMode.WRITE,
                        "buy_27",
                        FunctionResult.LONG,
                        List.of(Item.PER_KEY + itemId));
        if(q == -1){
            log.debug("已全部售出，购买失败");
            return -1;
        }
        var id = ulid.nextULID();
        Order o = Order.builder()
                .id(ulid.nextULID())
                .userId(userId)
                .itemId(itemId)
                .build();
        client.getBucket(Order.PER_KEY + id)
                .set(o);
        sendMessage(o);
        return q;
    }

    public void sendMessage(Order order){
        client.getStream(Order.STREAM_KEY,StringCodec.INSTANCE)
                .add(StreamAddArgs.entry("orderid",order.getId()));
    }
}
