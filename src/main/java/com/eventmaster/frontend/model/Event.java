package com.eventmaster.frontend.model;

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
public class Event {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime dateFrom;
    private LocalDateTime dateUntil;
}
