package com.restfull.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
       // RestAssured.port = Integer.parseInt("apidoc/index.html");
        RestAssured.basePath = "apidoc/index.html";
        //http://localhost:8080/student
    }
}
