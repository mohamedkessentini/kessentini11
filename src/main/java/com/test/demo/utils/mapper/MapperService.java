package com.test.demo.utils.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MapperService {
	@Autowired
	private MapperImpl mapperImpl;

	public List<Object> processMyData(List<List<Map<String, Object>>> data, Class<?>... classNames) {
		// Call the mapToListOfClasses method with the Class objects
		return mapperImpl.mapToListOfClasses(data, classNames);
	}

	//THIS METHOD AIMS TO CAST ANY LIST OF OBJECTS TO ENTITIES PASSED IN PARAMS
	public static <T> List<T> castList(List<Object> objectList, Class<T> targetType) {
		List<T> entityList = new ArrayList<>();

		for (Object obj : objectList) {
			// Perform the type cast for each object in the list
			if (targetType.isInstance(obj)) {
				T entity = targetType.cast(obj);
				entityList.add(entity);
				System.out.println(entity.getClass());
			} else {
				System.out.println("AN ERROR HAS OCCURRED DURING CASTING");
			}
		}

		return entityList;
	}
}