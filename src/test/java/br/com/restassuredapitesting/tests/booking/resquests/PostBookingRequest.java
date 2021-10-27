package br.com.restassuredapitesting.tests.booking.resquests;

import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    BookingPayloads bookingPayloads= new BookingPayloads();

    @Step("Cria uma reserva  ")
    public Response PostBooking()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }

    @Step("Cria uma reserva com parâmetro extra payload")
    public Response PostExtraBooking()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .when()
                .body(bookingPayloads.payloadParametroExtraBooking().toString())
                .post("booking");
    }

    @Step("Cria uma reserva com payload inválido  ")
    public Response PostBookingPayloadInvalid()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadInvalidoBooking().toString())
                .post("booking");
    }


    @Step("Cria uma reserva com Accept Invalido  ")
    public Response PostBookingAcceptInvalido()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","Invalido")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }
}



