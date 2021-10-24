package br.com.restassuredapitesting.tests.booking.resquests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retornar os ids das listagagem de reservas ")
    public Response bookingReturnIds(){
        return given()
                .when()
                .get("booking");



    }
}

