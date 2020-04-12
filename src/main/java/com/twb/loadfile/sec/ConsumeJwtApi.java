package com.twb.loadfile.sec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class ConsumeJwtApi {

//    @Autowired
//    RestTemplate restTemplate;

    @PostMapping("/auth-jwt-rest")
    public String authJwt(HttpServletRequest httpRequest){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("x-nanobnk-apikey", "A79jdaguK8XSWjJo5JnydyPrJ41JtsGg");
        AuthRequest authRequest = new AuthRequest("javainuse", "password");
        HttpEntity entity = new HttpEntity(authRequest, headers);
        String url = "http://localhost:8083/authenticate";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String token = resp.getBody();
        ObjectMapper mapper = new ObjectMapper();
        try{
            AuthResponse authJwtResp = mapper.readValue(token, AuthResponse.class);
            httpRequest.getSession().setAttribute("token", authJwtResp.getToken());
            Logger.getGlobal().info("\nResponse Token: "+authJwtResp.getToken());
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return token;
    }

    @GetMapping("/auth-jwt-rest-hello")
    public String helloAuth(HttpServletRequest httpRequest){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String token = "Bearer "+httpRequest.getSession().getAttribute("token");
        Logger.getGlobal().info("\nResponse Hello token: "+token);
        headers.add("Authorization", token);

//        AuthRequest authRequest = new AuthRequest("javainuse", "password");
        HttpEntity entity = new HttpEntity(null, headers);
        String url = "http://localhost:8083/hello";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String value = resp.getBody();
        Logger.getGlobal().info("\nResponse Hello: "+value);
//        httpRequest.getSession().setAttribute("token", value);
        return value;
    }

}


