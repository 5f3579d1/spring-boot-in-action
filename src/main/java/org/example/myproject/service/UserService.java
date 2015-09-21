package org.example.myproject.service;

import org.example.myproject.domain.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by k on 9/16/15.
 */
public interface UserService {

    Collection<User> findAll();

    Optional<User> findOne(long id);

    Optional<User> create(User user);

    Optional<User> update(User user);

    boolean delete(long id);

    Optional<User> findByUsername(String username);

}
