package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * @author Abhishek Kumar on 17/02/2024
 */
public class Getresponse {
    @Test
    void getfirstUser(){
        //https://reqres.in/api/users/2
        Response res = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println("Get single user response: "+res.asString());
        System.out.println("Get status code for single user:"+res.getStatusCode());


    }
}
