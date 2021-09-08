package com.example.demo.repository;


import com.example.demo.domain.ApplicationUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationUserRepository extends ApplicationRepository<ApplicationUser, Long> {

    public ApplicationUser findByUsername(String username);


    @Query("SELECT u FROM ApplicationUser u WHERE u.username = :username")
    public ApplicationUser getUserByUsername(@Param("username") String username);




}
