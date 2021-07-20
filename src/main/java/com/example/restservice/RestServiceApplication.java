package com.example.restservice;

import com.example.restservice.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class RestServiceApplication {
	String getUrl = "http://91.241.64.178:7081/api/users";
	String postUrl = "http://91.241.64.178:7081/api/users";
	String putUrl = "http://91.241.64.178:7081/api/users";
	String deleteUrl = "http://91.241.64.178:7081/api/users/3";
	private static RestTemplate restTemplate = new RestTemplate();
	List<String> cookie = new ArrayList<>();

	public static void main(String[] args) {
		RestServiceApplication restClient = new RestServiceApplication();

		restClient.getUsers();
		restClient.addUser();
		restClient.editUser();
		restClient.deleteUser();


	}

	public void getUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		cookie = response.getHeaders().get("Set-Cookie");
		response.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
		System.out.println(response.getBody());
	}

	public void addUser() {
		User user = new User(3L,"James", "Brown", (byte) 23);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Cookie",cookie.stream().collect(Collectors.joining(";")));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		ResponseEntity<String> response = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);
		System.out.println(response.getBody());

	}

	public void editUser() {
		User user = new User(3L,"Thomas", "Shelby", (byte) 23);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Cookie",cookie.stream().collect(Collectors.joining(";")));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		ResponseEntity<String> response = restTemplate.exchange(putUrl, HttpMethod.PUT, entity, String.class);
		System.out.println(response.getBody());

	}

	public void deleteUser() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Cookie",cookie.stream().collect(Collectors.joining(";")));
		HttpEntity<User> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, entity, String.class);
		System.out.println(response.getBody());

	}

}
