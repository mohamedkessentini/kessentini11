package com.test.demo.utils.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
 
@Component
public class MapperImpl {
    private final ModelMapper modelMapper;
 
    @Autowired
    public MapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
 
    public List<Object> mapToListOfClasses(List<List<Map<String, Object>>> data, Class<?>... targetClasses) {
        return data.stream()
                .flatMap(List::stream)
                .map(map -> mapToObject(map, targetClasses))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
 
    private Object mapToObject(Map<String, Object> map, Class<?>[] targetClasses) {
        if (map.isEmpty() || map.values().stream().allMatch(Objects::isNull)) {
            return null;
        }
 
        for (Class<?> targetClass : targetClasses) {
            Object mappedObject = modelMapper.map(map, targetClass);
            
            // Set null for missing attributes
            Arrays.stream(targetClass.getDeclaredFields())
                    .filter(field -> !map.containsKey(field.getName())) // Check if attribute exists in the map
                    .forEach(field -> {
                        try {
                            field.setAccessible(true);
                            field.set(mappedObject, null); // Set the attribute to null in the mapped object
                        } catch (IllegalAccessException e) {
                            // Handle exception appropriately
                            e.printStackTrace();
                        }
                    });
            
            // Check if the mapped object contains any non-null attributes
            try {
                if (Arrays.stream(targetClass.getDeclaredFields())
                        .anyMatch(field -> {
                            try {
                                field.setAccessible(true);
                                return field.get(mappedObject) != null;
                            } catch (IllegalAccessException e) {
                                // Handle exception appropriately
                                e.printStackTrace();
                                return false;
                            }
                        })) {
                    return mappedObject;
                }
            } catch (Exception e) {
                // Handle exception appropriately
                e.printStackTrace();
            }
        }
 
        return null;
    }
 
}