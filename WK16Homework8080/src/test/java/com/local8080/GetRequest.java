package com.local8080;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {
        @Test
        public void getProduct() {

            given().log().all()
                    .when()
                    .get("http://localhost:3030/products")
                    .then().log().all()
                    .statusCode(200);


        }
    }
