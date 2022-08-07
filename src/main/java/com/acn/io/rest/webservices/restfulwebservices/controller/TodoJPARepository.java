package com.acn.io.rest.webservices.restfulwebservices.controller;

import com.acn.io.rest.webservices.restfulwebservices.beans.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJPARepository extends JpaRepository<Todos,Long> {

       List<Todos> findByUsername(String username);
}

