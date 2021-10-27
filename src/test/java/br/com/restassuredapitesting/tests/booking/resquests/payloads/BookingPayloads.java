package br.com.restassuredapitesting.tests.booking.resquests.payloads;

import org.json.JSONObject;

public class BookingPayloads {

    public  static  JSONObject payloadValidBooking(){

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname","Cristiano");
        payload.put("lastname", "Ronaldo");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        return payload;
    }

    public  static  JSONObject payloadInvalidoBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("invalido","2018-01-01");
        bookingDates.put("invalid","2019-01-01");

        payload.put("firstname","Jim");
        payload.put("lastname", "Brown");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        return payload;
    }

    public  static  JSONObject payloadParametroExtraBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-07-10");
        bookingDates.put("checkout","2019-05-14");

        payload.put("firstname","JuliaAR");
        payload.put("lastname", "da silva");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        payload.put("parametroExtra" , "parametroExtraPayloads");

        return payload;
    }
}
