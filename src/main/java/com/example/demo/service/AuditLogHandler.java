package com.example.demo.service;

import com.example.demo.domain.AbstractAuditingEntity;
import com.example.demo.domain.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.Optional;

public class AuditLogHandler implements AuditorAware<ApplicationUser> {

    @Autowired
    protected ApplicationUserRepository userRepository;

    @Override
    public Optional<ApplicationUser> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long applicationUserId;

        if (authentication == null || authentication.getDetails() == null) {
            applicationUserId = -1;
        }
        else {
            String userName=authentication.getName();

            applicationUserId=userRepository.getUserByUsername(userName).getId();
        }
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setId(applicationUserId);
        System.out.println(applicationUserId);
        return Optional.of(applicationUser);
    }


}
