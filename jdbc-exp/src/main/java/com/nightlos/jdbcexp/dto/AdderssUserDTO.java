package com.nightlos.jdbcexp.dto;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdderssUserDTO {
    private User user;
    private Address address;
}
