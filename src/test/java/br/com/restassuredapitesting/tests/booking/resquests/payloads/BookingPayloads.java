package br.com.restassuredapitesting.tests.booking.resquests.payloads;

import org.json.JSONObject;

public class BookingPayloads {

    public  static JSONObject BookingPayloads(){

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2018-01-01");
        payload.put("fistname","Cristiano");
        payload.put("lastname","Ronaldo");
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingDates",bookingDates);
        payload.put("additionalneeds","Breakfast");


     return payload;

    }
}
