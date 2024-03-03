package com.api.framework.api;

import com.api.framework.utils.FileNameConstants;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Abhishek Kumar on 03/03/2024
 */
public class PostAPIRequestUsingFile {
    @Test
    public void postAPIRequest() {


        try {
            String postAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY));
Response response =
            RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(postAPIRequestBody)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            System.out.println(response.getBody().asString());
          //JSONArray jsonArray =  JsonPath.read(response.body().asString(),"$.booking.firstname");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
