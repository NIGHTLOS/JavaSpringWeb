package com.nightlos.redisexp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public static final String PER_KEY = "orders:";
    public static final String STREAM_KEY = "orders:process";
    public static final String GROUP_NAME = "consumer-group";
    public static final String GROUP_CONSUMER = "consumer-1";

    private String id;
    private String userId;
    private String itemId;

}
