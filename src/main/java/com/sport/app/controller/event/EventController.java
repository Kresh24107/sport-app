package com.sport.app.controller.event;

import com.sport.app.controller.MessageResponse;
import com.sport.app.exception.NotFoundException;
import com.sport.app.repository.entity.ApplicationUser;
import com.sport.app.repository.entity.Event;
import com.sport.app.service.ApplicationUserService;
import com.sport.app.service.EventService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("event/")
public class EventController {

    private EventService eventService;
    private ApplicationUserService applicationUserService;

    public EventController(EventService eventService, ApplicationUserService applicationUserService) {
        this.eventService = eventService;
        this.applicationUserService = applicationUserService;
    }

    @PostMapping
    public MessageResponse saveEvent(@RequestBody EventDTO dto) {
        Event event = new Event(dto);
        ApplicationUser applicationUser = applicationUserService.getApplicationUserById(dto.getApplicationUserId()).orElseThrow(
                () -> new NotFoundException("No such event"));
        event.setApplicationUser(applicationUser);
        eventService.saveEvent(event);
        return new MessageResponse("saved");
    }

    @GetMapping
    public EventDTO getEventById(@RequestParam int id) {
        Event event = eventService.getEventById(id).orElseThrow(
                () -> new NotFoundException("No such event"));
        return new EventDTO(event);
    }

    @DeleteMapping
    public MessageResponse deleteById(@RequestParam int id) {
        Event event = eventService.getEventById(id).orElseThrow(
                () -> new NotFoundException("No such event"));
        eventService.deleteById(id);
        return new MessageResponse("deleted");
    }

    @GetMapping("/by/user/id")
    public List<EventDTO> getEventsByUserId(@RequestParam int id) {
        ArrayList<EventDTO> result = new ArrayList<>();
        eventService.getEventsByUserId(id).forEach(event -> result.add(new EventDTO(event)));
        return result;
    }

    @GetMapping("/date")
    public List<EventDTO> getEventsByDate(@RequestParam String date) throws ParseException {
        Date formatedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Event> eventsByDate = eventService.getEventsByDate(formatedDate);
        return null;
    }
}
