package br.com.restassuredapitesting.tests.ping.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequest {

        public Response PingReturnApi(){
            return given()
                    .header("Content-Typer","aplication/json")
                    .when()
                    .get("ping");

        }
}
