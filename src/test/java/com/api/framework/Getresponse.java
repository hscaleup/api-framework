package com.api.framework;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 18/02/2024
 */
public class Getresponse {
   @Test
    public void test001(){
    Response res = get("https://reqres.in/api/users?page=2");
    System.out.println(res.getStatusCode());
    System.out.println(res.getBody().asString());
    System.out.println(res.getHeader("Content-Type"));
    System.out.println(res.getTime());
    int expectedStatusCode = 200;
    int actualStatusCode = res.getStatusCode() ;
    Assert.assertEquals(expectedStatusCode ,actualStatusCode);
    }
    @Test
    public void test002(){
    baseURI ="https://reqres.in/api/users";
    given().queryParam("page","2").when().get().then().statusCode(200);
    }
}
