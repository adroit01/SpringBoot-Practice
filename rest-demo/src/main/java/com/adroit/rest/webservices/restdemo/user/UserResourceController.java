package com.adroit.rest.webservices.restdemo.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService userDaoService;
	//RetrieveAllUsers
	//GET	/users	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers()
	{
		return userDaoService.getAllUsers();
	}
	
	//RetrieveUser
	//GET /users/{id}
	@GetMapping(path ="/users/{id}")
	public User retrieveUser(@PathVariable String id) throws Exception
	{
		User user = userDaoService.getUser(id);
		return user;
	}
	//Create a user
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@RequestBody User user) 
	{
		User createdUser = userDaoService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Number of Users
	@GetMapping(path="/users/userCount")
	public int getUserCount()
	{
		return userDaoService.getUserCount();
	}
}
