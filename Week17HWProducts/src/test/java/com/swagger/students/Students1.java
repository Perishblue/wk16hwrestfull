package com.swagger.students;

import com.swagger.model.StudentPojo;
import com.swagger.model.utils.TestUtils;
import com.swagger.testbase.TestBase1;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Students1 extends TestBase1 {
    static String firstName = "dars"+ TestUtils.getRandomValue();
    static String lastname = "visnu" + TestUtils.getRandomValue();
    static String programme = "java testing";
    static String email = TestUtils.getRandomValue()+ "@gmail.com";
    static int studentId;

    @Test
    public void getStudentInfo(){
        given()
                .when()
                .get("/list")
                .then().statusCode(404);
    }

    @Test
    public void getStudentInfoById(){
        Response response =given().log().all()
                .pathParam("id","3")
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }
    @Test
    public void CreateStudent(){

        List<String> courseList = new ArrayList<>();
        courseList.add("selenium");
        courseList.add("cypress");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);

        Response response =given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .post();
        response.then().statusCode(405);

    }
    @Test
    public void StudentList(){

        HashMap<String, Object> studentData =given()
                .when()
                .get("/list")
                .then()
                .statusCode(404)
                .extract().path("findAll{it.firstName =='"+firstName+"'}.get(0)");

        studentId= (int) studentData.get("id");
        System.out.println(studentId);
    }
    @Test
    public void VerifyStudentID(){

        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .get("/{id}");
        response.then().log().all().statusCode(404).body("firstName", equalTo(firstName));

    }
    @Test
    public void DeleteBYID(){

        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .delete("/{id}");
        response.then().log().all().statusCode(404);

    }
    @Test
    public void DeleteComformtion(){

        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .get("/{id}");
        response.then().log().all().statusCode(404);

    }
}
