package com.eventmaster.frontend.service.event;
import com.eventmaster.frontend.controller.event.dto.CategoryDto;
import com.eventmaster.frontend.controller.event.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {
   List<EventDto> findAllEvents();

   void addEvent(EventDto eventDto);

   List<CategoryDto> findAllCategories();
}
