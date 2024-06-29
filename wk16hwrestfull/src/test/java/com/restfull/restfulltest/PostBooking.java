package com.restfull.restfulltest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostBooking {

    @Test
    public void createNewEmployee() {

       given().log().all()
                .when()
               .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Darshan\",\n" +
                        "    \"lastname\" : \"Visnudas\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking")
                .then().log().all()
                .statusCode(200);
    }
}
