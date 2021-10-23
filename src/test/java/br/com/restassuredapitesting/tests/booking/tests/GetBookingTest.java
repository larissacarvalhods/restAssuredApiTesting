package br.com.restassuredapitesting.tests.booking.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.booking.resquests.GetBookingRequest;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class GetBookingTest  extends BaseTest {
GetBookingRequest getBookingRequest =  new GetBookingRequest();
    @Test
    @Category({AllTest.class})
    public void validarListagemIdsReservas(){

        getBookingRequest.BookingReturnId()

                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }
}
