package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.PostBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@Feature("Feature - Criar reserva")

    public class PostBookingTest extends BaseTest {

        PostBookingRequest postBookingRequest = new PostBookingRequest();
        GetBookingRequest getBookingRequest = new GetBookingRequest();
        PostAuthRequest postAuthRequests = new PostAuthRequest();

        BookingPayloads bookingPayloads = new BookingPayloads();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Criar uma nova reserva ")

    public void CriarUmaNovaReserva() {

        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("JuliaAR"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Criar  mais de uma nova reserva em sequencia ")

    public void CriarMaisUmaReservaSequencia() {

        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("Jim"));

        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("Jim"));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva ")

    public void CriarUmaReservaComPayloadInvalido() {
        postBookingRequest.PostBookingPayloadInvalid(  )
                .then()
                .statusCode(500);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Validar retorno 418 quando o header Accept for invalido ")

    public void ValidarAcceptInvalido() {
        postBookingRequest.PostBookingAcceptInvalido(  )
                .then()
                .statusCode(418);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class})
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")

    public void ValidarCriarUmaReservaExtraPayload() {
        postBookingRequest.PostExtraBooking()
                .then()
                .statusCode(200);
    }


}
