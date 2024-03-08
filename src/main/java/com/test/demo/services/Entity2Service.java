package com.test.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dao.implementation.Entity2Impl;
import com.test.demo.entity.Entity2;

@Service
public class Entity2Service {
	@Autowired
	private Entity2Impl entity2Impl;
	
	public List<Entity2> getEntity2(){
		return entity2Impl.getEntity2();
	}

}
