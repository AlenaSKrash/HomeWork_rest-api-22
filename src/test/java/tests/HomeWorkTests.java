package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.get;

public class HomeWorkTests {

    @Test
    void getListTotalCheck(){
        given()
                .log().uri()
                .log().method()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .body("total", is(12));
    }

    @Test
    void getListStatusCheck(){
        given()
                .log().uri()
                .log().method()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .log().status()
                .statusCode(200);
    }

    @Test
    void getSingleUserNotFoundStatus404(){
        given()
                .log().uri()
                .log().method()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    void postCreateUserStatusCheck(){
        String bodyUser = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .body(bodyUser)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    void deleteUserStatusCheck(){

        given()
                .log().uri()
                .log().method()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(204);
    }




}
