package controller;

import model.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventController {
    private List<Event> events;

    public EventController() {
        this.events = new ArrayList<>();
    }

    public void createEvent(String name, String address, String category, LocalDateTime dateTime, String description) {
        Event event = new Event(name, address, category, dateTime, description);
        events.add(event);
        System.out.println("Event created successfully: " + event.getName());
    }

    public List<Event> getEvents() {
        return events;
    }
}
