package com.restfull.restfulltest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetBookingByID {
    @Test
    public void getAllBooking() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/201")
                .then().log().all()
                .statusCode(200)
                .body("data.firstname", equalTo("John"))
                .body("message", equalTo("Breakfast"));
    }
}
