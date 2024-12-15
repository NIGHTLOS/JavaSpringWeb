package com.nightlos.redisexp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    public static final String PER_KEY = "items:";
    private String id;
    private int total;

}
