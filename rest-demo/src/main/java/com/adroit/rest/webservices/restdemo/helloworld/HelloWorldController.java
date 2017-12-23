package com.adroit.rest.webservices.restdemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	//GET
	/**
	 * This method return a String
	 * Maps to URI /hello-world
	 */
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path ="/hello-world")
	public String helloWorld()
	{
		return "My Hello World";
	}
	
	@GetMapping(path ="/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path ="/hello-world/{company}/{developer}")
	public HelloWorldBean helloWorldBean(@PathVariable String company,@PathVariable String developer)
	{
		return new HelloWorldBean("Hello World " + company +":" + developer);
	}
}
