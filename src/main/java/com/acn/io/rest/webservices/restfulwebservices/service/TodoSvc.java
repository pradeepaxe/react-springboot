package com.acn.io.rest.webservices.restfulwebservices.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acn.io.rest.webservices.restfulwebservices.beans.Todos;

@Service
public class TodoSvc {
	
	private static List<Todos> todos = new ArrayList();
	
	private static Long idCounter=0L;
	
	static {
		todos.add(new Todos(++idCounter, "in28minutes","learn to dance", new Date(), false));
		todos.add(new Todos(++idCounter, "in28minutes","learn to play", new Date(), true));
		todos.add(new Todos(++idCounter, "in28minutes","learn to exercise", new Date(), false));
		todos.add(new Todos(++idCounter, "in28minutes","learn to sleep", new Date(), true));

		
	
	}
	
	
	
	public Todos Save(Todos id) {
		
		if(id.getId()==-1 || id.getId()==0	) {
			id.setId(++idCounter);
			todos.add(id);
		}else {
			deleteById(id.getId());
			todos.add(id);
		}
		
		return id;
		
	}
	
	public List<Todos> findAll(){
		return todos;
	}
	
	public Todos deleteById(long id){
		 Todos todo  = findById(id);
		 
		 if(todo==null) return null;
		 
		 if(todos.remove(todo)) {
			 return todo;
		 }
		 return null;
	}

	public Todos findById(long id) {
//		for(Todos todo : todos) {
//			if(todo.getId()==id) {
//				return todo;
//			}
//			
//		}
		
		return todos.stream().filter(todo->todo.getId()==id).findFirst().get();
	}
	

}
