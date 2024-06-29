package com.local3030.myfirsttestpractice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProducts {

    @Test
    public void getProduct() {

        given()
                .when()
                .get("http://localhost:3030/products")
                .then().log().all()
                .statusCode(200);


    }
}
