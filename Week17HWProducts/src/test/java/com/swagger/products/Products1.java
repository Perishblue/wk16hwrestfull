package com.swagger.products;

import com.swagger.model.Datum;
import com.swagger.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Products1 extends TestBase {


    int idNumber;
    @Test
    public void GetProducts(){
        Products products = given().log().all()
                .when()
                .get()
                .getBody().as(Products.class);
        System.out.println(products.getTotal());

    }
    @Test
    public void CreatNewProduts(){

        Datum datum = new Datum();
        datum.setName("dars");
        datum.setType("hghj");
        datum.setPrice(123F);
        datum.setShipping(34);
        datum.setUpc("hjghnknvhv");
        datum.setDescription("desg");
        datum.setManufacturer("audi");
        datum.setModel("tesla");
        datum.setUrl("kjad mllbfsjbg");
        datum.setImage("mn mn ");
        Datum datum1=given()
                .log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(datum)
                .post()
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getId());
        idNumber=datum1.getId();


    }
    @Test
    public void GetbyID(){


        Datum datum1=given()
                .log().all()
                .pathParam("id", idNumber)
                .when()
                .get("/{id}")
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getName());

    }
    @Test
    public void UpdatebyID(){

        Datum datum = new Datum();
        datum.setPrice(123F);
        datum.setShipping(34);
        datum.setUpc("hjghnknvhv");
        datum.setDescription("desg");
        datum.setManufacturer("audi");
        datum.setModel("tesla");

        Response response=given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", idNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(404);

    }
    @Test
    public void DeletebyID(){


        Response response=given()
                .log().all()
                .pathParam("id", idNumber)
                .when()
                .delete("/{id}");
        response.then().statusCode(404);


    }
    @Test
    public void DeletebyIDupdate(){

        Response response=given()
                .log().all()
                .pathParam("id", idNumber)
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }
}
