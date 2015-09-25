package org.example.myproject.securtity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.myproject.domain.User;
import org.example.myproject.service.UserService;
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

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("load user: " + username);

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username=%s was not found", username)));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles().toString()));
    }

}