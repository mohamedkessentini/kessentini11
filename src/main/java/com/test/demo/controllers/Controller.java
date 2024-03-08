package com.test.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.entity.Entity1;
import com.test.demo.services.DemoService;

@RestController
@RequestMapping("/")

public class Controller {
	@Autowired
	private DemoService demoService;


	//TESTING FOR A COMPLEX QUERY THAT CONTAINS MANY SPS AND A TEMP TABLE CREATION
	@GetMapping("/CustomQuery")
	public List<List<Map<String, Object>>> execComplexQuery(@RequestHeader("SpName") String spName, @RequestHeader("TempName") String tempName) {
		System.out.println(spName+"\n"+tempName);
		return demoService.execQueryResult(spName,tempName);
	}
	@GetMapping("/EntityOne")
	public List<Entity1> getEntity1(){
		
		return null;
	}

}
