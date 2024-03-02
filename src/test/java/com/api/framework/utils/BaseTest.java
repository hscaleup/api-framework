package com.api.framework.utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

/**
 * @author Abhishek Kumar on 02/03/2024
 */
public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
