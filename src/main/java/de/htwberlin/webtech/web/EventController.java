package de.htwberlin.webtech.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventRepository repository;

    @Autowired
    public EventController(EventRepository repository) {
        this.repository = repository;
    }
    // Eine Methode, um ein Event zu erstellen und zu speichern
    public Event createEvent(String title, LocalDateTime start, LocalDateTime end) {
        Event event = new Event();
        event.setTitle(title);
        event.setStart(start);
        event.setEnd(end);
        return repository.save(event);
    }
    // methods to handle HTTP requests
}