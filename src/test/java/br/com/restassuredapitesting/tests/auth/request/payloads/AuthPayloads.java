package br.com.restassuredapitesting.tests.auth.request.payloads;

import org.json.JSONObject;

public class AuthPayloads {


        public  JSONObject jsonAuthLogin(){
            JSONObject payload= new JSONObject();
            payload.put("username","admin");
            payload.put("password","password123");
            return payload;
        }
    }

