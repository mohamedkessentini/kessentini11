package com.test.demo.utils.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
 
@Service
public class MapperService {
    private final MapperImpl mapperImpl;
 
    @Autowired
    public MapperService(MapperImpl MapperImpl) {
        this.mapperImpl = MapperImpl;
    }
 
    public List<Object> processMyData(List<List<Map<String, Object>>> data, Class<?>... classNames) {
        // Call the mapToListOfClasses method with the Class objects
        return mapperImpl.mapToListOfClasses(data, classNames);
    }
}