package com.swagger.products;

import com.swagger.model.Datum;
import com.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Products3 extends TestBase {
    int IdNumber;
    private boolean total;

    @Test
    public void AllProducts(){
        com.swagger.model.Products products = given()
                .when()
                .get()
                .getBody()
                .as(com.swagger.model.Products.class);
        System.out.println(products.getTotal());
    }

    @Test
    public void CreateProducts(){
        Datum datum=new Datum();
        datum.setName("ice-cream");
        datum.setType("SoftGood");
        datum.setPrice(8.99F);
        datum.setUpc("bjfbjdbbkjx");
        datum.setShipping(22);
        datum.setDescription("createisveryhighqulitymatireal");
        datum.setManufacturer("Vadilal");
        datum.setModel("FirstTrial");
        datum.setUrl("www.valilalicecream.com");
        datum.setImage("mm_kk_YY_TT_RR");
        Datum datum1= given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(datum)
                .post()
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getId());
        IdNumber=datum1.getId();
    }

    @Test
    public void ProductsGetById(){
        Datum datum1=given()
                .log().all()
                .pathParam("id", IdNumber)
                .when()
                .get("/{id}")
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getName());
    }

    @Test
    public void UpdateProductsByID(){
        Datum datum=new Datum();
        datum.setPrice(234F);
        datum.setShipping(45);
        datum.setUpc("hjkisfbljx");
        datum.setDescription("newnew");
        datum.setManufacturer("NewVanila");
        datum.setModel("Icecreamdolly");
        datum.setImage("NEW Photo");

        Response response=given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id", IdNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(404);
    }
    @Test
    public void DeleteProductsByID(){
        Response response=given().log().all()
                .pathParam("id",IdNumber)
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
    }

    @Test
    public void DeleteProductsVerify(){
        Response response=given().log().all()
                .pathParam("id",IdNumber)
                .when()
                .get("/{id}");
        response.then().statusCode(404);
    }

    public boolean getTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }
}
