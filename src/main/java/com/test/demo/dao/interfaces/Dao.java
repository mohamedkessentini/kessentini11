package com.test.demo.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface Dao {
    List<List<Map<String, Object>>> execQueryResult(String sqlBlock);
}
