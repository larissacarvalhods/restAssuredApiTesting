package br.com.restassuredapitesting.tests.ping.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;

@Feature("Feature - Api Online")

    public class GetPingTest extends BaseTest {

        GetPingRequest getPingRequests= new GetPingRequest();
        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Category({AllTests.class})

        @DisplayName("Verificar se a api está online")

        public void validaApiOnline(){
            getPingRequests.pingReturnApi()
                    .then()
                    .statusCode(201);

        }


    }

