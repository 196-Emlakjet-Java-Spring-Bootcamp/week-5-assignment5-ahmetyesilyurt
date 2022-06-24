package com.ysl.rabbitmq.dao;

import com.ysl.rabbitmq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users ORDER BY random() LIMIT 1", nativeQuery = true)
    User generateUser();
}
