package com.sport.app.controller.application_user;

import com.sport.app.controller.MessageResponse;
import com.sport.app.exception.NotFoundException;
import com.sport.app.repository.entity.ApplicationUser;
import com.sport.app.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("application/user")
public class ApplicationUserController {

    private ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping
    public MessageResponse saveApplicationUser(@RequestBody ApplicationUserDTO dto) {
        applicationUserService.saveUser(new ApplicationUser(dto));
        return new MessageResponse("saved");
    }

    @GetMapping
    public ApplicationUserDTO getApplicationUserByID(@RequestParam int id) {
        ApplicationUser user = applicationUserService.getApplicationUserById(id).orElseThrow(
                () -> new NotFoundException("No such user"));
        return new ApplicationUserDTO(user);
    }

    @GetMapping("/last/four/ids")
    public List<Integer> getLastFourUsersIds() {
        return applicationUserService.getLastFourUsersIds();
    }

    @GetMapping("/last/four")
    public List<ApplicationUserDTO> getLastFourUsers() {
        List<ApplicationUserDTO> result = new ArrayList<>();
        applicationUserService.getLastFourApplicationUsers().forEach(user -> result.add(new ApplicationUserDTO(user)));
        return result;
    }
}
