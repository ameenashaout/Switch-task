package com.example.demo.web.rest;

import com.example.demo.domain.ApplicationUser;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.service.ApplicationUsersService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class ApplicationUserController   extends AbstractResource<ApplicationUser> {

    public ApplicationUserController(ApplicationUsersService business) {
        this.business = business;
    }

    @GetMapping("/application-users/{application_user_id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @Override
    public ApplicationUser getDocument(@PathVariable("application_user_id") Long documentId) {
        return super.getDocument(documentId);
    }



    @PostMapping("/application-users")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @Override
    public ApplicationUser addDocument(@RequestBody ApplicationUser document) throws BusinessException {
        return super.addDocument(document);
    }

    @DeleteMapping("/application-users/{application_user_id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void deleteDocument(@PathVariable("application_user_id") Long documentId) throws BusinessException {
        super.deleteDocument(documentId);
    }
}
