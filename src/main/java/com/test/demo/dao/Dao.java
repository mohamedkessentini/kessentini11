package com.test.demo.dao;

import java.util.List;
import java.util.Map;

public interface Dao {
    List<List<Map<String, Object>>> callSp(String...spNameParams);
    String generateSpName(String...args);
}
