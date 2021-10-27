package br.com.restassuredapitesting.tests.booking.resquests;

import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.resquests.payloads.BookingPayloads;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class GetBookingRequest {

    @Step("Retornar os ids das listagem de reservas ")
    public Response bookingReturnIds() {
        return given()
                .when()
                .get("booking");
    }

    @Step("Retornar uma reserva específica")
    public Response bookingReturnEspecificId(int id) {
        return given()
                .when()
                .get("booking/"+ id);
    }

    @Step("Listagem das reservas ultilizando 2 filtros de pesquisa")
    public Response bookingReturnIdsFilter2(String filtro, String valorfiltro,String filtro2, String valorfiltro2){
        return given()
                .queryParams(filtro,valorfiltro,filtro2,valorfiltro2)
                .when()
                .get("booking");
    }


    @Step("Listagem das reservas ultilizando 3 filtros de pesquisa")
    public Response bookingReturnIdsFilter3(String filtro, String valorfiltro,String filtro2, String valorfiltro2,String filtro3, String valorfiltro3){
        return given()
                .queryParams(filtro,valorfiltro,filtro2,valorfiltro2,filtro3,valorfiltro3)
                .when()
                .get("booking");
    }


    @Step("Listagem das reservas utilizando um filtro de pesquisa")
    public Response bookingReturnIdsFilter1(String filtro, String valorfiltro){
        return given()
                .queryParams(filtro,valorfiltro)
                .when()
                .get("booking");
    }


}











