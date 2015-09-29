package org.example.myproject.service;

import org.example.myproject.domain.base.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by k on 9/16/15.
 */
public interface AccountService {

    Page<Account> findAll(Pageable pageable);

    Optional<Account> findOne(long id);

    Optional<Account> create(Account account);

    Optional<Account> update(Account account);

    void delete(long id);

    Optional<Account> findByUsername(String username);

}
