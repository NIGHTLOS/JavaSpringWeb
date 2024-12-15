package com.nightlos.jdbcexp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCountDTO {
    private String userId;
    private int count;
    private String name;
}
