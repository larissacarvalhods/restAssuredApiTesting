package br.com.restassuredapitesting.tests.booking.tests;


import base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.suites.SchemaTets;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de Reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Listar os IDs de reservas")

    public void validaListaIdsDasReservas() {

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o Schema de returno de listagem de reservas")

    public void validaSchemaListaDaReserva() {

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .log().all()
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o Schema de retorno de uma  reserva específica ")

    public void RetornarReservaEspecifica() {

        getBookingRequest.bookingReturnEspecificId(50)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookingId"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class, SchemaTets.class})
    @DisplayName("Garantir o Schema de retorno de uma  reserva específica ")

    public void validaSchemaReservaEspecifica() {

        getBookingRequest.bookingReturnEspecificId(50)
                .then()
                .statusCode(200)
                .log().all()
                .body("size()", greaterThan(0));

    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName(" Lista os ids das reservas por firstname ")
    public void ListarIdsDasReservasPorFisrtName() {

        getBookingRequest.bookingReturnIdsFilter1("firstname", "Jim")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas por LastName")
    public void ListarIdsDasReservasPorLastName() {

        getBookingRequest.bookingReturnIdsFilter1("lastname", "Brown")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas por Chekin")
    public void ListarIdsDasReservasPorChekin() {

        getBookingRequest.bookingReturnIdsFilter1("checkin", "2018-01-01")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas por Checkout")
    public void ListarIdsDasReservasPorCheckout() {

        getBookingRequest.bookingReturnIdsFilter1("checkout", "2019-01-01")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas por Chekout e Checkout")
    public void ListarIdsDasReservasPorCheckoutCheckout() {

        getBookingRequest.bookingReturnIdsFilter2("checkout", "2018-01-01", "checkout", "2019-01-01")
                .then()
                .statusCode(500)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas por FisrtName, Chekin e Checkout")
    public void ListarIdsDasReservasPorFisrtNameChekinCheckout() {

        getBookingRequest.bookingReturnIdsFilter3("firstname", "Jim","checkin", "2018-01-01","checkout", "2019-05-14")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

}
