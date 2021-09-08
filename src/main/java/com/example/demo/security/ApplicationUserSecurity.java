package com.example.demo.security;


import com.example.demo.domain.ApplicationUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ApplicationUserSecurity implements UserDetails {
    private static final long serialVersionUID = 1L;

     private ApplicationUser applicationUser;

    private long id;

    public long getId() {
        return applicationUser.getId();
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplicationUserSecurity(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + applicationUser.getUserRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return applicationUser.getPassword();
    }

    @Override
    public String getUsername() {
        return applicationUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !applicationUser.isDisabled();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
