package com.nightlos.jdbcexp.repository;

import com.nightlos.jdbcexp.dox.User;
import com.nightlos.jdbcexp.dto.UserAddressDTO;
import com.nightlos.jdbcexp.dto.UserCountDTO;
import com.nightlos.jdbcexp.mapper.UserExtractor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    @Query(value = """
           select * from user u join address a
            on u.id=a.user_id
            where u.id=:uid
       """,
            resultSetExtractorClass = UserExtractor.class)
    UserAddressDTO findByUserId(String uid);
    @Query("""
           select u.id as user_id,u.name,
           count(a.user_id) as count from user u left join address a
           on u.id=a.user_id
           group by u.id
           order by count;
           """)
    List<UserCountDTO> findCount();
}
