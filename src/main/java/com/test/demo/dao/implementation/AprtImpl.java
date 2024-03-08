package com.test.demo.dao.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.demo.dao.interfaces.AprtInterface;
import com.test.demo.entity.Aprt;
import com.test.demo.utils.SqlCalls;

public class AprtImpl implements AprtInterface{
	@Autowired
	private DaoImpl daoImpl;
	
	@Override
	public List<Aprt> getAprt() {
		List<List<Map<String,Object>>> ResultSets=daoImpl.execQueryResult("DO NOT EXECUTE UNLESS YOU HAVE THE SQL BLOCK FOR THE APRT ENTITY");
		
		return null;
	}

}
