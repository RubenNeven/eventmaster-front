package com.eventmaster.frontend.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long id;
    @NotBlank(message = "Event name is required")
    @NotNull(message = "Event name is required")
    @Size(min = 1)
    private String name;
    private BigDecimal price;
    @NotBlank(message = "Location is required")
    @Size(min = 1, message = "Location is required")
    private String location;
    private Category category;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateUntil;


}
