package com.apodoba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apodoba.domain.User;
import com.apodoba.service.UserService;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User account = service.getUserById((long) 1);
        if(account == null) {
            throw new UsernameNotFoundException("no user found with " + name);
        }
        return new AccountUserDetails(account);
    }
}