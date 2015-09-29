package org.example.myproject.service.impl;

import org.example.myproject.domain.base.Account;
import org.example.myproject.repository.AccountRepository;
import org.example.myproject.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import java.util.Optional;

/**
 * Created by k on 9/16/15.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AccountRepository repository;

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Account> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Account> create(Account account) {
        logger.info("> create");

        if (account.getId() != null) {
            logger.error("Attempted to create a Account, but id attribute was not null.");
            logger.info("< create");
            throw new EntityExistsException(
                    "Cannot create new Account with supplied id.  The id attribute must be null to create an entity.");
        }

        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        Account saved = repository.save(account);

        logger.info("< create");
        return Optional.ofNullable(saved);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Account> update(Account account) {
        logger.info("> update {}", account.getId());

        Account persisted = repository.findOne(account.getId());
        if (persisted == null) {
            logger.error("Attempted to update a Account, but the entity does not exist.");
            logger.info("< update {}", account.getId());
            throw new NoResultException("Requested Account not found.");
        }

        persisted.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        Account updated = repository.save(persisted);

        logger.info("< update {}", updated.getId());
        return Optional.ofNullable(updated);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(long id) {
        logger.info("> delete {}", id);

        repository.delete(id);

        logger.info("< delete {}", id);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
