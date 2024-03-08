package com.test.demo.dao.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.demo.dao.interfaces.Entity2Interface;
import com.test.demo.entity.Entity2;
import com.test.demo.utils.SqlCalls;
import com.test.demo.utils.mapper.MapperService;

@Repository
public class Entity2Impl implements Entity2Interface {

	@Autowired
	private DaoImpl daoImpl;
	@Autowired
	private MapperService mapperService;

	@Override
	public List<Entity2> getEntity2() {
		// Retrieve the list of result sets from the database
		List<List<Map<String, Object>>> ResultSets = daoImpl.execQueryResult(SqlCalls.sqlTestEntities());
		// Process the resultsets and extract the entity2 objects from it
		List<Object> mappedObject = mapperService.processMyData(ResultSets, Entity2.class);
		// Perform the cast method in order to get List<Entity2>
		List<Entity2> entity = MapperService.castList(mappedObject, Entity2.class);
		System.out.println(entity.getClass());
		return entity;

	}
}
