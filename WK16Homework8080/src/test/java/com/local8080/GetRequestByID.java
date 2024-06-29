package com.local8080;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequestByID {

    @Test
    public void ByID() {

        given().log().all()
                .when()
                .get("http://localhost:8080/student/1")
                .then().log().all()
                .statusCode(200);


    }
}
