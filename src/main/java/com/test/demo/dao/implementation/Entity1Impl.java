package com.test.demo.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.demo.dao.interfaces.Entity1Interface;

import com.test.demo.entity.Entity1;
import com.test.demo.utils.SqlCalls;
import com.test.demo.utils.mapper.MapperService;

@Repository
public class Entity1Impl implements Entity1Interface {

	@Autowired
	private DaoImpl daoImpl;
	@Autowired
	private MapperService mapperService;

	@Override
	public List<Entity1> getEntity1() {
		// Retrieve the list of result sets from the database
		List<List<Map<String, Object>>> ResultSets = daoImpl.execQueryResult(SqlCalls.sqlTestEntities());
		List<Object> mappedObject = mapperService.processMyData(ResultSets, Entity1.class);
		// NOW WE NEED TO CAST THE LIST OF OBJECTS TO A LIST OF ENTITY1
		List<Entity1> entity = castList(mappedObject);
		System.out.println(entity.getClass());
		return entity;
	}
/* THIS METHOD CASTS AN OBJECT TO AN ENTITY1 OBJECT*/
	private List<Entity1> castList(List<Object> objectList) {
		List<Entity1> entityList = new ArrayList<>();

		for (Object obj : objectList) {
			// Perform the type cast for each object in the list
			if (obj instanceof Entity1) {
				Entity1 entity = (Entity1) obj;
	            entityList.add(entity);
	            System.out.println(entity.getClass());
			} else {
				System.out.println("AN ERROR HAS OCCURED DURING CASTING");
			}
		}

		return entityList;
	}
}