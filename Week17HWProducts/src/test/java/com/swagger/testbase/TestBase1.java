package com.swagger.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase1 {
    @BeforeClass
    public static void URL() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }
}
