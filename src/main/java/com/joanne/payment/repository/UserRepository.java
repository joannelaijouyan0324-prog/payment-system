package com.joanne.payment.repository;


import com.joanne.payment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Talking to Database
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
