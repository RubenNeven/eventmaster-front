package com.eventmaster.frontend.controller.event;

import com.eventmaster.frontend.controller.event.dto.EventDto;
import com.eventmaster.frontend.controller.event.dto.EventDtoList;
import com.eventmaster.frontend.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping()
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public ResponseEntity<EventDtoList> findAllEvents() {
        List<EventDto> events = eventService.findAllEvents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new EventDtoList(events));
    }
}
