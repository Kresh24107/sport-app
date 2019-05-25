package com.sport.app.service;

import com.sport.app.repository.ApplicationUserRepository;
import com.sport.app.repository.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService {
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public Optional<ApplicationUser> getApplicationUserById(int id) {
        return applicationUserRepository.findById(id);

    }

    public void saveUser(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }
}
