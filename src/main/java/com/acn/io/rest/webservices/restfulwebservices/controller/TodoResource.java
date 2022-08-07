package com.acn.io.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acn.io.rest.webservices.restfulwebservices.beans.Todos;
import com.acn.io.rest.webservices.restfulwebservices.service.TodoSvc;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class TodoResource {
	
	@Autowired
	private TodoSvc todoSvc;
	
	@GetMapping(path="/users/{username}/todos")
	public List<Todos> getAllTodos(@PathVariable String username){
		return todoSvc.findAll();
	}
	
	@GetMapping(path="/users/{username}/todos/{id}")
	public Todos getTodos(@PathVariable String username,
			@PathVariable long id){
	
		return todoSvc.findById(id);
	}
	
	
	
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodos
	(@PathVariable String username, @PathVariable long id){
		 Todos todo = todoSvc.deleteById(id);
		 if(todo!=null) {
			 return ResponseEntity.noContent().build();
		 }
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todos> UpdateTodos
	(@PathVariable String username, @PathVariable long id
			,@RequestBody Todos todos){
		 Todos todo = todoSvc.Save(todos);
		return new ResponseEntity<Todos>(todo,HttpStatus.OK);
		  
	}
	
	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<Void> UpdateTodos
	(@PathVariable String username, 
			@RequestBody Todos todos){
		 Todos createdTodo = todoSvc.Save(todos);
	//	return new ResponseEntity<Todos>(todo,HttpStatus.OK);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
					
	}
}
