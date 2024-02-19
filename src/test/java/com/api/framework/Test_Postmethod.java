package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 19/02/2024
 */
public class Test_Postmethod {

    @Test
    public void test001(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("name","Prachi");
        jsonData.put("job","QA");

        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.given().header("content-type","application/json").contentType(ContentType.JSON)
                .body(jsonData.toJSONString())
                .when().put()
                .then().statusCode(200)
                .log().all();

    }
}
