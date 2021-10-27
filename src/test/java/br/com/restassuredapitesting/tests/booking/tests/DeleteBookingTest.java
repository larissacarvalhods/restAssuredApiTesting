package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;

import br.com.restassuredapitesting.suites.AcceptanceTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

    @Feature("Feature - Exclusão de reserva")
    public class DeleteBookingTest extends BaseTest {

        DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
        GetBookingRequest getBookingRequest= new GetBookingRequest();
        PostAuthRequest postAuthRequests= new PostAuthRequest();


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class, AcceptanceTest.class})
        @DisplayName("Excluir uma reserva com sucesso")

        public void ExcluirReservaComAutorizacao() {

            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            deleteBookingRequest.deleteBookingToken(primeiroId,postAuthRequests.getToken() )
                    .then()
                    .statusCode(201);
        }


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class, E2eTests.class})
        @DisplayName("Excluir uma reserva  sem autorização")

        public void ExcluirReservaSemAutorização() {
            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            deleteBookingRequest.deleteBookingSemToken(primeiroId )
                    .then()
                    .statusCode(403);
        }


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class,E2eTests.class})
        @DisplayName("Excluir uma reserva  que nao existe")
        public void ExcluirUmaReservaInexistente() {

            deleteBookingRequest.deleteBookingToken(98271292,postAuthRequests.getToken() )
                    .then()
                    .statusCode(405);
        }

    }

