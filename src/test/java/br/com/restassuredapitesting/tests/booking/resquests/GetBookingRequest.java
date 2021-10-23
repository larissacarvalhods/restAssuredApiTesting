package br.com.restassuredapitesting.tests.booking.resquests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    public Response BookingReturnId(){
        return given()
                .when()
                .get("booking");

    }
}
