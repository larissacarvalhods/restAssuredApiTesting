package br.com.restassuredapitesting.tests.booking.resquests;

import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {


        BookingPayloads bookingPayloads= new BookingPayloads();

        @Step("Atualiza uma reserva especifica com o paramentro token")
        public  Response updateBookingToken(int id, String token)
        {
            return given()
                    .header("Content-Type", "application/json")
                    .header("Accept","application/json")
                    .header("Cookie"  ,token )
                    .when()
                    .body(bookingPayloads.payloadValidBooking().toString())
                    .put("booking/"+ id);
        }

    @Step("Atualiza uma reserva especifica sem o paramentro token")
    public  Response updateBookingSemToken(int id)
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }

    @Step("Atualiza uma reserva especifica com o paramentro token")
    public  Response updateBookingBasicAuth(int id)
    {

        return given()
                .header("Content-Type", "application/json")
                .header("Authorisation", "Basic YWRtaW46cGFzc3dvcmQxMjM=" )
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }




}
