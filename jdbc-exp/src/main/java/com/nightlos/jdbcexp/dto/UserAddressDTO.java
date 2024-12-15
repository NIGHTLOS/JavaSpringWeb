package com.nightlos.jdbcexp.dto;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddressDTO {
    private User user;
    private List<Address> addresses;
}
