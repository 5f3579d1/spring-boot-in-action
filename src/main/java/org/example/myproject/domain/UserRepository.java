package org.example.myproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by k on 9/15/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);

}
