package com.ons.springsecurity.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ons.springsecurity.model.User;
import com.ons.springsecurity.repository.UserRepository;
import com.ons.springsecurity.rest.RestUser;

@RestController
@RequestMapping (value = "/rest")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	public List<User> users(){
		return repository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping("/users")
	public User AddUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public void update(@RequestBody User newUser, @PathVariable Long id) {
		if(repository.existsById(id)) {
			User existingUser= repository.getOne(id);
			existingUser.setFirstName(newUser.getFirstName());
			existingUser.setLastName(newUser.getLastName());
			existingUser.setReportingManager(newUser.getReportingManager());
			existingUser.setUsername(newUser.getUsername());
			existingUser.setPassword(newUser.getPassword());
			repository.save(existingUser);
		}
	}
	
	@DeleteMapping ("/users/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	//rest
	@GetMapping (value = "/user-assets")
	public List<RestUser> UserAssets(){
		HttpHeaders header= new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity <String> entity= new HttpEntity<String>(header);
//		ResponseEntity<String> result=restTemplate.exchange("http://localhost:8082/it-admin/userassets", HttpMethod.GET, entity, String.class);
//		System.out.println("result:----------------------------------------------------------------------\n "+result+"\n--------------------------------------------");
		ResponseEntity<RestUser[]> responseEntity= restTemplate.getForEntity("http://localhost:8082/it-admin/userassets", RestUser[].class);
		List<RestUser> users= Arrays.asList(responseEntity.getBody());
		System.out.println("returning: "+users);
		return users;
	}
	
}
