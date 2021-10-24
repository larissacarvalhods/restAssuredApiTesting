package br.com.restassuredapitesting.tests.ping.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.AllTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

    @Feature("Feature - Api Online")

    public class GetPingTest extends BaseTest {

        GetPingRequest getPingRequests= new GetPingRequest();
        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Category({AllTests.class})

        @DisplayName("Verificar se a api esta online")

        public void validaApiOnline(){
            getPingRequests.pingReturnApi()
                    .then()
                    .statusCode(201);

        }


    }

