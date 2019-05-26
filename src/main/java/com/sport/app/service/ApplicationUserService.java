package com.sport.app.service;

import com.sport.app.repository.ApplicationUserRepository;
import com.sport.app.repository.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Integer> getLastFourUsersIds() {
        List<Integer> ids = applicationUserRepository.findAll()
                .stream()
                .map(ApplicationUser::getId)
                .collect(Collectors.toList());
        if (ids.size() <= 4) {
            return ids;
        }
        List<Integer> result = new ArrayList<>();
        result.add(ids.get(ids.size() - 1));
        result.add(ids.get(ids.size() - 2));
        result.add(ids.get(ids.size() - 3));
        result.add(ids.get(ids.size() - 4));
        return result;
    }

    public List<ApplicationUser> getLastFourApplicationUsers(){
        List<ApplicationUser> users = applicationUserRepository.findAll();
        if (users.size() <= 4){
            return users;
        }
        List<ApplicationUser> result = new ArrayList<>();
        result.add(users.get(users.size() - 1));
        result.add(users.get(users.size() - 2));
        result.add(users.get(users.size() - 3));
        result.add(users.get(users.size() - 4));
        return result;
    }

    public void saveUser(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }
}
