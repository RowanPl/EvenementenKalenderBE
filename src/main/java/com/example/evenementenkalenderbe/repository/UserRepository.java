package com.example.evenementenkalenderbe.repository;

import com.example.evenementenkalenderbe.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
