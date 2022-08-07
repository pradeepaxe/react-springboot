package com.acn.io.rest.webservices.restfulwebservices.controller;

import com.acn.io.rest.webservices.restfulwebservices.beans.Todos;
import com.acn.io.rest.webservices.restfulwebservices.service.TodoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class TodoJPAResource {
	
	@Autowired
	private TodoSvc todoSvc;

	@Autowired
	private TodoJPARepository todoRepo;
	
	@GetMapping(path="/jpa/users/{username}/todos")
	public List<Todos> getAllTodos(@PathVariable String username){
		return todoRepo.findByUsername(username);
	}
	
	@GetMapping(path="/jpa/users/{username}/todos/{id}")
	public Todos getTodos(@PathVariable String username,
			@PathVariable long id){

		return todoRepo.findById(id).get();
		//return todoSvc.findById(id);
	}
	
	
	
	@DeleteMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodos
	(@PathVariable String username, @PathVariable long id){
		 todoRepo.deleteById(id);
		 return ResponseEntity.noContent().build();

	}

	@PutMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todos> UpdateTodos
	(@PathVariable String username, @PathVariable long id
			,@RequestBody Todos todos){
		todos.setUsername(username);
		 Todos todo = todoRepo.save(todos);
		return new ResponseEntity<Todos>(todo,HttpStatus.OK);
		  
	}
	
	@PostMapping(path="/jpa/users/{username}/todos")
	public ResponseEntity<Void> UpdateTodos
	(@PathVariable String username, 
			@RequestBody Todos todos){
		todos.setUsername(username);

		Todos createdTodo = todoRepo.save(todos);
	//	return new ResponseEntity<Todos>(todo,HttpStatus.OK);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
					
	}
}
