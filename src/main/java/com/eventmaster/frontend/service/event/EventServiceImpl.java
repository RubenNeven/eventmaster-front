package com.eventmaster.frontend.service.event;

import com.eventmaster.frontend.controller.event.dto.EventDto;
import com.eventmaster.frontend.controller.event.dto.EventDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final RestTemplate restTemplate;

    @Autowired
    public EventServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public List<EventDto> findAllEvents() {
        ResponseEntity<EventDtoList> eventDtoListResponseEntity = restTemplate.getForEntity("http://localhost:8081/api/events", EventDtoList.class);
        EventDtoList eventDtoList = eventDtoListResponseEntity.getBody();
        List<EventDto> events = eventDtoList.getEventList();
        return events;
    }

    @Override
    public void addEvent(EventDto eventDto) {
        restTemplate.postForEntity("http://localhost:8081/api/events", eventDto, EventDto.class);
    }
}
