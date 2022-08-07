package com.acn.io.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.io.rest.webservices.restfulwebservices.beans.HelloWorldBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	
//	GET
	//URL- /helloworld
	
	@GetMapping(path="/helloworld")
	public String getHelloWorld() {
		return "hello world";
	}
	@GetMapping(path="/helloworld-bean")
	public HelloWorldBean getHelloWorldBean() {
		return  new HelloWorldBean("Hello-world-bean");
	}
	
	@GetMapping(path="/helloworld-bean/path-variable/{name}")
	public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name) throws RuntimeException {
		try {
			return new HelloWorldBean(String.format("Hello World, %s", name));

		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
				
	
		}
}
