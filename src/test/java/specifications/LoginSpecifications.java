package specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseLogSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class LoginSpecifications {
    public static RequestSpecification loginRequestSpecifications = with()
            .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api/login");

    public static ResponseSpecification loginResponseSpecifications = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification missingPasswordSpecification = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(400)
            .build();
}
