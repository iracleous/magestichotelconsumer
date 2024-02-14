package gr.codehub.hotelcosumer.controller;

import gr.codehub.hotelcosumer.dto.BookingDto;
import gr.codehub.hotelcosumer.dto.ResponseApi;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
public class HotelConsumerController {

    @GetMapping("book")
    public ResponseApi<BookingDto> createBooking(){
        int customerId = 1;
        int roomId =2;
        LocalDate startingDate = LocalDate.of(2024,3,1);
        LocalDate endingDate = LocalDate.of(2024,3,2);

        RestTemplate restTemplate = new RestTemplate();

        BookingDto bookingDto = new BookingDto(customerId, roomId, startingDate, endingDate);

        String url ="http://localhost:8090/booking/create";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BookingDto> request = new HttpEntity<>(bookingDto, headers);
        ResponseEntity<ResponseApi<BookingDto>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<ResponseApi<BookingDto>>(){}  );
        ResponseApi<BookingDto> respList =   response.getBody();
        return respList;

    }

}
