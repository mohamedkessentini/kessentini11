package com.test.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.entity.Entity2;
import com.test.demo.services.Entity2Service;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")

public class Entity2Controller {

	@Autowired
	Entity2Service entity2Service;
	
	@GetMapping("entity2")
	public List<Entity2> getMethodName() {
		
		return entity2Service.getEntity2();
	}
	
}
