package com.eventmaster.frontend.controller.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String location;
    private LocalDateTime dateFrom;
    private LocalDateTime dateUntil;
}
