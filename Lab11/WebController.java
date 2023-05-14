package com.example.Lab11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebController {
    private List<String> listOfUsers=  Arrays.asList("ana","maria");
    @GetMapping("/getUsers") public List<String> home() {
        return listOfUsers;
    }
//    public void getUsers() throws IOException {
//        URL url = new URL("http://localhost:8081/users");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//    }
}
