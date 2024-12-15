package com.nightlos.backendexp.repository;

import com.nightlos.backendexp.dox.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {

    User findByAccount(String account);
}
