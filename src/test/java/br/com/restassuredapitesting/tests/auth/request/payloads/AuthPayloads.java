package br.com.restassuredapitesting.tests.auth.request.payloads;

import org.json.JSONObject;

public class AuthPayloads {
    public  static JSONObject JsonAuthLogin(){

        JSONObject payloadLogin = new JSONObject();
        payloadLogin.put("username" , "admin");
        payloadLogin.put("password","password123");
        return payloadLogin;
    }


}
