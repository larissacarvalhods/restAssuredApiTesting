package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;


    @Feature("Feature - Atualização de Reservas")
    public class PutBookingTest extends BaseTest {
        PutBookingRequest putBookingRequest = new PutBookingRequest();
        GetBookingRequest getBookingRequest = new GetBookingRequest();
        PostAuthRequest postAuthRequests = new PostAuthRequest();


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class})
        @DisplayName("Alterar uma reserva utilizando o token")

        public void ValidarAlteracaoUmaReservaUtilizandoToken() {
            int primeiroId = getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            putBookingRequest.updateBookingToken(primeiroId, postAuthRequests.getToken())
                    .then()
                    .statusCode(200)
                    .log().all()
                    .body("size()", greaterThan(0));

        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class, E2eTests.class})
        @DisplayName("Alterar uma reserva  utilizando o token inválido")

        public void AlterarUmaReservaTokenInvalido() {
            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            putBookingRequest.updateBookingToken(primeiroId,"TOken invalido" )
                    .then()
                    .statusCode(403);
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class,E2eTests.class})
        @DisplayName("Alterar  uma reserva inexestente")
        public void alterarUmaReservaInexistente() {

            putBookingRequest.updateBookingToken(12321312,postAuthRequests.getToken() )
                    .then()
                    .statusCode(405);
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class, E2eTests.class})
        @DisplayName("Alternar uma reserva sem o token")
        public void AlterarUmaReservaSemToken() {
            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            putBookingRequest.updateBookingSemToken(primeiroId )
                    .then()
                    .statusCode(403);

        }


        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTests.class, AcceptanceTest.class})
        @DisplayName("Alterar uma reserva utilizando o Basic Auth")

        public void ValidarAlteracaoUmaReservaUtilizandoBasic() {

            int primeiroId= getBookingRequest.bookingReturnIds()
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("[0].bookingid");

            putBookingRequest.updateBookingBasicAuth(primeiroId )
                    .then()
                    .statusCode(200)
                    .body("size()", greaterThan(0));

        }
    }