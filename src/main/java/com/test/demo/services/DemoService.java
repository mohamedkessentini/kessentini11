package com.test.demo.services;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dao.implementation.DaoImpl;
import com.test.demo.utils.SqlCalls;


/* THIS SPRING DEMOSERVICE HAS A METHOD executeQueryResult THAT TAKES A STRING AS AN INPUT FROM THE CONTROLLER AND PASSES IT TO THE DAO FOR EXECUTION */


@Service
public class DemoService {
	@Autowired
	private DaoImpl daoImpl;
    //TESTING
    public List<List<Map<String, Object>>> execQueryResult(String spName, String tempName){
        return this.daoImpl.execQueryResult(SqlCalls.sql1(spName,tempName));
    }
}
