package tests;

import models.LoginBody;
import models.LoginResponse;
import models.MissingPassword;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specifications.LoginSpecifications.*;

public class HomeWorkLesson21 {

    @Test
        void successfulLoginTest() {
            LoginBody loginBody = new LoginBody();
            loginBody.setEmail("eve.holt@reqres.in");
            loginBody.setPassword("cityslicka");

        LoginResponse response = given(loginRequestSpecifications)
                .body(loginBody)
                .when()
                .post()
                .then()
                .spec(loginResponseSpecifications)
                .extract().as(LoginResponse.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    void missingPasswordLoginTest() {
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail("eve.holt@reqres.in");

        MissingPassword response = given(loginRequestSpecifications)
                .body(loginBody)
                .when()
                .post()
                .then()
                .spec(missingPasswordSpecification)
                .extract().as(MissingPassword.class);

        assertEquals("Missing password", response.getError());
    }
}
