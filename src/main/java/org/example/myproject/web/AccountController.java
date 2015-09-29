package org.example.myproject.web;

import org.example.myproject.domain.base.Account;
import org.example.myproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by k on 9/22/15.
 */
@RestController
@RequestMapping(value = "account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity get(Pageable pageable) {
        logger.info("> get accounts");

        Page<Account> users = service.findAll(pageable);

        logger.info("< get accounts");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        logger.info("> get account {}", id);

        Optional<Account> user = service.findOne(id);

        if (!user.isPresent()) {
            logger.info("< get account");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("< get account {}", id);

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(Account account) {
        logger.info("> post account");

        Optional<Account> saved = service.create(account);

        if (!saved.isPresent())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        logger.info("< post account");
        return new ResponseEntity<>(saved.get(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(Account account) {
        logger.info("> put account");

        Optional<Account> updated = service.update(account);

        logger.info("< put account");
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        logger.info("> delete account");

        service.delete(id);

        logger.info("< delete account");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
