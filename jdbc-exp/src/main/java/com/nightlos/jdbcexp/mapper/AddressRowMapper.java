package com.nightlos.jdbcexp.mapper;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dox.User;
import com.nightlos.jdbcexp.dto.AdderssUserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddressRowMapper implements RowMapper<AdderssUserDTO> {
    @Override
    public AdderssUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=User.builder()
                .id(rs.getString("u.id"))
                .name(rs.getString("name"))
                .createTime(rs.getObject("create_time", LocalDateTime.class))
                .build();
        Address address = Address.builder()
                .id(rs.getString("a.id"))
                .detail(rs.getString("a.detail"))
                .userId(rs.getString("a.user_id"))
                .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                .build();
        return AdderssUserDTO.builder()
                .user(user)
                .address(address)
                .build();
    }
}
