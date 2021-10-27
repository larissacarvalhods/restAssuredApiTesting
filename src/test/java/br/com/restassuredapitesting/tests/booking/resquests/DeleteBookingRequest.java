package br.com.restassuredapitesting.tests.booking.resquests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class DeleteBookingRequest {

    BookingPayloads bookingPayloads= new BookingPayloads();

    @Step("Exclui uma reserva especifica ultilizando o token")
    public Response deleteBookingToken(int id, String token)
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie"  ,token )
                .when()
                .delete("booking/"+ id);
    }

    @Step("Exclui uma reserva especifica sem autorização")
    public Response deleteBookingSemToken(int id)
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .when()
                .delete("booking/"+ id);
    }



}
