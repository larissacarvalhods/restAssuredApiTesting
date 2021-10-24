package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.resquests.PutBookingRequest;
import com.fasterxml.jackson.databind.JsonSerializable;
import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.AllTests;

import static org.hamcrest.Matchers.greaterThan;

public class PutBookingTest extends BaseTest {
    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest= new GetBookingRequest();
    PostAuthRequest postAuthRequest= new PostAuthRequest();

    @Test
    @Category({AllTests.class})
    public void ValidarAlteracaoUmaReservaUtilizandoToken() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroId,postAuthRequest.getToken() )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));


    }
}
