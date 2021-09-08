package com.example.demo.security;

import com.example.demo.domain.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository repository;

          @Override
             public UserDetails loadUserByUsername(String username)
              throws UsernameNotFoundException {
             ApplicationUser user = repository.getUserByUsername(username);

            if (user == null) {
               throw new UsernameNotFoundException("Could not find user");}

              ApplicationUserSecurity userSecurityDetails = new ApplicationUserSecurity(user);

              return userSecurityDetails;



              }
}
