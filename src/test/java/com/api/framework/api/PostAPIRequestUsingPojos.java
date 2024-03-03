package com.api.framework.api;

import com.api.framework.pojos.Booking;
import com.api.framework.pojos.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 03/03/2024
 */
public class PostAPIRequestUsingPojos {

    @Test
    public void postAPIRequest() {

        try {
            BookingDates bookingDates = new BookingDates("2023-03-25", "2030-03-30");
            Booking booking = new Booking("api testing", "tutorials", "super bowls", 1000, true, bookingDates);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
            System.out.println("Json request Bosy"+requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
