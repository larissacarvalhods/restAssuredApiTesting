package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.PutBookingRequest;
import com.fasterxml.jackson.databind.JsonSerializable;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.AllTests;

import static org.hamcrest.Matchers.greaterThan;


    @Feature("Feature - Atualização de Reservas")
    public class PutBookingTest extends BaseTest {
        PutBookingRequest putBookingRequest = new PutBookingRequest();
        GetBookingRequest getBookingRequest= new GetBookingRequest();
        PostAuthRequest postAuthRequests= new PostAuthRequest();


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class})
        @DisplayName("Alternar uma reserva somente utilizando o token")
        public void ValidarAlteracaoUmaReservaUtilizandoToken() {
            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            putBookingRequest.updateBookingToken(primeiroId,postAuthRequests.getToken() )
                    .then()
                    .statusCode(200)
                    .body("size()", greaterThan(0));

        }
    }
