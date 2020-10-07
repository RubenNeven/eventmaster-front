package com.eventmaster.frontend.controller.event;

import com.eventmaster.frontend.controller.event.dto.CategoryDto;
import com.eventmaster.frontend.controller.event.dto.CategoryDtoList;
import com.eventmaster.frontend.controller.event.dto.EventDto;
import com.eventmaster.frontend.controller.event.dto.EventDtoList;
import com.eventmaster.frontend.controller.event.mapper.EventMapper;
import com.eventmaster.frontend.model.Event;
import com.eventmaster.frontend.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping()
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
    public String eventForm(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("categories", eventService.findAllCategories());
        return "addEvent";
    }

    @GetMapping("/events")
    public String eventDetails(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "eventDetails";
    }

    @PostMapping("/new")
    public String addEventForm(@Valid @ModelAttribute("event") Event event, BindingResult br){
        if (br.hasErrors()){
            return "addEvent";
        }
        eventService.addEvent(eventMapper.map(event));
        return "redirect:/new";
    }


}
