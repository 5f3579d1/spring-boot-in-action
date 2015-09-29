package org.example.myproject.securtity;

import org.example.myproject.domain.base.Account;
import org.example.myproject.service.AccountService;
import org.example.myproject.util.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by k on 9/18/15.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CurrentUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("load account: " + username);

        Account account = accountService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Account with username=%s was not found", username)));

        RequestContext.setUsername(username);

        return new org.springframework.security.core.userdetails.User(account.getUsername(),
                account.getPassword(), AuthorityUtils.createAuthorityList(account.getRoles().toString()));
    }

}