package com.eventmaster.frontend.controller.event.mapper;

import com.eventmaster.frontend.controller.event.dto.EventDto;
import com.eventmaster.frontend.controller.event.dto.EventDtoList;
import com.eventmaster.frontend.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    public Event map(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .price(eventDto.getPrice())
                .location(eventDto.getLocation())
                .dateFrom(eventDto.getDateFrom())
                .dateUntil(eventDto.getDateUntil())
                .build();
    }

    public EventDto map(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .price(event.getPrice())
                .location(event.getLocation())
                .dateFrom(event.getDateFrom())
                .dateUntil(event.getDateUntil())
                .build();
    }


    public EventDtoList convertToEventDtoList(List<Event> events){
        return EventDtoList.builder()
                .eventList(events.stream().map(this::map).collect(Collectors.toList()))
                .build();
    }
}
