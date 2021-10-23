package br.com.restassuredapitesting.tests.booking.resquests;

import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    public Response updateBookingToken(int Id, String token) {

        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token")
                .when()
                .body(bookingPayloads.toString())
                .put("booking" + Id);
    }
}