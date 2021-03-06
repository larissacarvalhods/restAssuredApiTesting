package br.com.restassuredapitesting.tests.auth.request;

import br.com.restassuredapitesting.tests.auth.request.payloads.AuthPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
public class PostAuthRequest {

    AuthPayloads authPayloads= new AuthPayloads();

    @Step("Retorna o token")
    public Response tokenReturn(){

        return given()
                .header("Content-Type", "application/json")
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    @Step("Busca o token")
    public String getToken(){
        return  "token="+ this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}


