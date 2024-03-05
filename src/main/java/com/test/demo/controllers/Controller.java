package com.test.demo.controllers;

import java.util.List;
import java.util.Map;

import com.test.demo.entity.EntityOne;
import com.test.demo.entity.EntityTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.services.TestService;

@RestController
@RequestMapping("/")

public class Controller {
	@Autowired
	private TestService testService;

	@GetMapping("/call-sp")
	public List<List<Map<String, Object>>> callSp() {

		return testService.GetAllResults("ADMIN..aprt_sel_testmka");
	}

	@GetMapping("/call-sp1")
	public List<List<Map<String, Object>>> callSp1() {

		return testService.GetAllResults("ADMIN..aprt_sel_testmkos", "test_int = 0", "test_vr ='12'");
	}

	@GetMapping("/EntityOnes")
	public List<EntityOne> getAllEntityOnes() {

		return testService.getAllEntityOnes("ADMIN..aprt_sel_testmkos", "test_int = 0", "test_vr ='12'");
	}

	@GetMapping("/EntityTwos")
	public List<EntityTwo> getAllEntityTwos() {

		return testService.getAllEntityTwos("ADMIN..aprt_sel_testmkos", "test_int = 0", "test_vr ='12'");
	}
	
	
	@GetMapping("/temp")
	public List<List<Map<String, Object>>> callTemp() {

		return testService.GetAllResults("ADMIN..aprt_sel_01", "aidprt='9913027'", "sft='i'");
	}
	
	@GetMapping("/GO")
	public List<List<Map<String, Object>>> GO() {

		return testService.GetAllResults("ADMIN..aprt_sel_20");
	}
	


}
