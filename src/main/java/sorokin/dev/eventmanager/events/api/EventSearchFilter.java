package sorokin.dev.eventmanager.events.api;

import sorokin.dev.eventmanager.events.domain.EventStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventSearchFilter(
        String name,
        Integer placesMin,
        Integer placesMax,
        LocalDateTime dateStartAfter,
        LocalDateTime dateStartBefore,
        BigDecimal costMin,
        BigDecimal costMax,
        Integer durationMin,
        Integer durationMax,
        Integer locationId,
        EventStatus eventStatus
) {}

