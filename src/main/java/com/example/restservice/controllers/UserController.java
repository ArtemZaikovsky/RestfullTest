//package com.example.restservice.controllers;
//
//import com.example.restservice.model.User;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class UserController {
//
//    String getUrl = "http://91.241.64.178:7081/api/users";
//    String postUrl = "http://91.241.64.178:7081/api/users";
//    String putUrl = "http://91.241.64.178:7081/api/users";
//    String deleteUrl = "http://91.241.64.178:7081/api/users/{id}";
//    List<String> cookie = new ArrayList<>();
//
//
//    public String getUsers() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <String> entity = new HttpEntity<String>(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        cookie = response.getHeaders().get("Set-Cookie");
//        response.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//        System.out.println(response.getBody());
//        return response.getBody();
//    }
//
//    @PostMapping("/api/users")
//    public String addUser() {
//        User user = new User(3L,"James", "Brown", (byte) 23);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
////        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.set("Cookie",cookie.stream().collect(Collectors.joining(";")));
//        HttpEntity<User> entity = new HttpEntity<>(user, headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//        System.out.println("User created: " + user);
//        System.out.println(response.getBody());
//        return response.getBody();
//    }

//    @PutMapping("/api/users")
//    public ResponseEntity editUser(@RequestBody User user) {
//        Long userId = 3L;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.PUT, entity, User.class);
//
//    }


