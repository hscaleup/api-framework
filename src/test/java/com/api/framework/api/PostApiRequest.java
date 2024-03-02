package com.api.framework.api;

import com.api.framework.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 01/03/2024
 */
public class PostApiRequest extends BaseTest {

    @Test
    public void createBookings() {

        //Prepare request body
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        booking.put("firstname", "api-testing");
        booking.put("lastname", "tutorial");
        booking.put("totalprice", "1000");
        booking.put("depositpaid", "true");
        booking.put("bookingdates", bookingDates);

        bookingDates.put("checkin", "2023-02-24");
        bookingDates.put("checkout", "2023-02-25");
Response response =
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(booking.toString())
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    //.log().body()
                    //.log().headers()
                    //.log().all()
                .when()
                    .post()
                .then()
                    .assertThat()
                    //.log().all()
                    //.log().ifValidationFails()
                    .statusCode(200)
                    .body("booking.firstname", Matchers.equalTo("api-testing"))
                    .body("booking.bookingdates.checkin", Matchers.equalTo("2023-02-24"))
                .extract()
                    .response();
        int bookingId = response.path("bookingid");
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .pathParam("bookingID",bookingId)
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                .when()
                    .get("{bookingID}")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("firstname",Matchers.equalTo("api-testing"))
                    .body("lastname",Matchers.equalTo("tutorial"));






    }
}
