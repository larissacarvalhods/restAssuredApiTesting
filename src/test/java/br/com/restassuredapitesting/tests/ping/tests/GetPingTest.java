package br.com.restassuredapitesting.tests.ping.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequest;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class GetPingTest extends BaseTest {

    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Category({AllTest.class})
    public void validarApiONline(){

        getPingRequest.PingReturnApi()
              .then()
              .statusCode(201);
    }


}
