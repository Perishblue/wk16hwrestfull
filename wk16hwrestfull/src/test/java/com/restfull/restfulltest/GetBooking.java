package com.restfull.restfulltest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking {

    @Test
    public void getAllBooking() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200);
    }
}
