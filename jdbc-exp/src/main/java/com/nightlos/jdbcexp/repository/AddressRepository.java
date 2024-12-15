package com.nightlos.jdbcexp.repository;

import com.nightlos.jdbcexp.dox.Address;
import com.nightlos.jdbcexp.dto.AdderssUserDTO;
import com.nightlos.jdbcexp.mapper.AddressRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    /*@Query("""
           SELECT a.* FROM address a
           where a.user_id=:userId
           """)*/
    List<Address> findByUserId(String userId);
    @Query(value="select * from address a,user u where a.user_id=u.id and a.id=:aid",
    rowMapperClass= AddressRowMapper.class)
    AdderssUserDTO findByAId(String aid);
}
