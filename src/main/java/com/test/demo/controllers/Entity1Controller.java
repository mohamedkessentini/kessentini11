package com.test.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.entity.Entity1;
import com.test.demo.services.Entity1Service;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")

public class Entity1Controller {

	@Autowired
	Entity1Service entity1Service;
	
	@GetMapping("entity1")
	public List<Entity1> getMethodName() {
		
		return entity1Service.getEntity1();
	}
	
}
