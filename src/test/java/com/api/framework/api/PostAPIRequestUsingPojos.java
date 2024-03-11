package com.api.framework.api;

import com.api.framework.pojos.Booking;
import com.api.framework.pojos.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
            //Serialization
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
            System.out.println("Json request Body" + requestBody);
            //De-serialization
             //  Booking bookingDetails = objectMapper.readValue(requestBody, Booking.class);
            //System.out.println(bookingDetails.getFirstname());
            //System.out.println(bookingDetails.getTotalprice());

            //System.out.println(bookingDetails.getBookingdates().getCheckin());
            //System.out.println(bookingDetails.getBookingdates().getCheckout());

           Response response =
            RestAssured
                    .given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                        .post()
                    .then()
                        .assertThat()
                        .statusCode(200)
                    .extract().response();
            System.out.println(response.getBody().asString());
           int bookingid = response.path("bookingid");
            System.out.println(bookingid);

           RestAssured
                   .given()
                    .contentType(ContentType.JSON)
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                   .when()
                    .get("/{bookingId}",bookingid )
                   .then()
                    .assertThat()
                    .statusCode(200);


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
