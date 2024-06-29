package com.local3030.myfirsttestpractice;

import io.restassured.specification.Argument;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetProductsByID {


    @Test
    public void GetProductByID(){
        given()
                .when()
                .get("http://localhost:3030/products/43900")
                .then().log().all()
                .statusCode(200);
               // .body("message", equalTo("Successfully! All records has been fetched."));
    }
}
