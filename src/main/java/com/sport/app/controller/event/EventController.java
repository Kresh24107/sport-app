package com.sport.app.controller.event;

import com.backend.controller.MessageResponse;
import com.backend.exception.NotFoundException;
import com.backend.repository.entity.ApplicationUser;
import com.backend.repository.entity.Event;
import com.backend.service.ApplicationUserService;
import com.backend.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event/")
public class EventController {

    private EventService eventService;
    private ApplicationUserService applicationUserService;

    public EventController(EventService eventService, ApplicationUserService applicationUserService) {
        this.eventService = eventService;
        this.applicationUserService = applicationUserService;
    }

    @PostMapping("/save")
    public MessageResponse saveEvent(@RequestBody EventDTO dto) {
        Event event = new Event(dto);
        ApplicationUser applicationUser = applicationUserService.getApplicationUserById(dto.getApplicationUserId()).orElseThrow(
                () -> new NotFoundException("No such user"));
        event.setApplicationUser(applicationUser);
        eventService.saveEvent(event);
        return new MessageResponse("saved");
    }

    @GetMapping
    public EventDTO getEventById(@RequestParam int id) {
        Event event = eventService.getEventById(id).orElseThrow(
                () -> new NotFoundException("No such user"));
        return null;
    }
}
