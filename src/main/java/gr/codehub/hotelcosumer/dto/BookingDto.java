package gr.codehub.hotelcosumer.dto;

import java.time.LocalDate;

public record BookingDto (
        long customerId,
        long roomId,
        LocalDate checkInDate,
        LocalDate checkOutDate)
{}
