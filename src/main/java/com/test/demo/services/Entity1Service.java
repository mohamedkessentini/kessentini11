package com.test.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dao.implementation.Entity1Impl;
import com.test.demo.entity.Entity1;

@Service
public class Entity1Service {
	
	@Autowired
	private Entity1Impl entity1Impl;
	
	public List<Entity1> getEntity1(){
		return entity1Impl.getEntity1();
	}

}
