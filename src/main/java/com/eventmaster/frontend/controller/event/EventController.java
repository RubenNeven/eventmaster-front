package com.eventmaster.frontend.controller.event;

import com.eventmaster.frontend.controller.event.dto.EventDto;
import com.eventmaster.frontend.controller.event.dto.EventDtoList;
import com.eventmaster.frontend.controller.event.mapper.EventMapper;
import com.eventmaster.frontend.model.Event;
import com.eventmaster.frontend.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @Autowired
    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @GetMapping()
    public ResponseEntity<EventDtoList> findAllEvents() {
        List<EventDto> events = eventService.findAllEvents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new EventDtoList(events));
    }

    @GetMapping("/new")
    public String eventForm(@ModelAttribute("event") Event event){
        return "addEvent";
    }

    @PostMapping("/new")
    public String addEventForm(@Valid @ModelAttribute("event") Event event, BindingResult br){
        if (br.hasErrors()){
            return "addEvent";
        }
        eventService.addEvent(eventMapper.map(event));
        return "redirect:/events/new";
    }
}
