package org.example.myproject.repository;

import org.example.myproject.domain.base.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by k on 9/15/15.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String name);

}
