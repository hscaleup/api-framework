package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 18/02/2024
 */
public class Getresponse {
@Test
    public void test001(){
    Response res = RestAssured.get("https://reqres.in/api/users?page=2");
    System.out.println(res.getStatusCode());
    System.out.println(res.getBody().asString());
    System.out.println(res.getHeader("Content-Type"));
    System.out.println(res.getTime());
    int expectedStatusCode = 200;
    int actualStatusCode = res.getStatusCode() ;
    Assert.assertEquals(expectedStatusCode ,actualStatusCode);
    }
}
