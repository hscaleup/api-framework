package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 01/03/2024
 */
public class GetApiRequest {
    @Test
    public void getAllBookings() {
        Response response =
        RestAssured
                .given()
                     .contentType(ContentType.JSON)
                     .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                     .get()
                .then()
                    .assertThat()
                            .statusCode(200)
                            .statusLine("HTTP/1.1 200 OK")
                            .headers("Content-Type","application/json; charset=utf-8")
                .extract()
                    .response();
        System.out.println(response.getBody().asString());
        Assert.assertTrue(response.getBody().asString().contains("bookingid"));




    }
}
