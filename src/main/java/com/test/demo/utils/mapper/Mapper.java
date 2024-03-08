package com.test.demo.utils.mapper;

import java.util.List;
import java.util.Map;
 
public interface Mapper<T> {
	 List<Object> mapToListOfClasses(List<List<Map<String, Object>>> data, Class<?>... targetClasses);
}