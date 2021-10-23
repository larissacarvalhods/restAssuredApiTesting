package br.com.restassuredapitesting.tests.auth.request;

import br.com.restassuredapitesting.tests.auth.request.payloads.AuthPayloads;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
AuthPayloads authPayloads = new AuthPayloads();
    public Response tokenReturn(){

     return given()
             .header("Content-Type","application/json")
             .when()
             .body(authPayloads.JsonAuthLogin().toString())
             .post("auth");
    }

    public String getToken(){
        return "token" + this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
