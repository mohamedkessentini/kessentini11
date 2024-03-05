package com.test.demo.daoImpl;
 
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.test.demo.dao.Dao;
 
@Repository
public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String generateSpName(String...args){
		String spname="EXEC ";
		String var="";
		spname+=args[0];
		for (int i=1; i<args.length; i++) {
			if (i<args.length-1) {
				var=" @"+args[i]+",";
			}
			else
				var=" @"+args[i];
			spname+=var;
			System.out.println(spname);
		}
		System.out.println(spname);
		return spname;
	}
 
	@Override
	public List<List<Map<String, Object>>> callSp(String...spNameParams) {
		return jdbcTemplate.execute((Connection con) -> {
			String x ="CREATE TABLE #apri_01  ("+
                    "azprto CHAR(7),"+
                    "azprtc CHAR(7) NULL," +
                    "allprt CHAR(30) NULL, "+
                    "acdtpo CHAR(2) NULL," +
                    "alltpo CHAR(30) NULL," +
                    "type CHAR(1) NULL"+
                ")";
			
			
			String Go = "create table #aprt_imp_01"+
					"("+
					  "aidprt char(7) null  /* code portef */"+
					")"+
					  "create unique clustered index #aprt_imp_01 on  #aprt_imp_01(aidprt)";
			
			
			PreparedStatement preparedStatement = con.prepareStatement(Go);
			boolean ok = preparedStatement.execute();
			System.out.println(ok);
			
			List<List<Map<String, Object>>> resultList = new ArrayList<>();
			try (CallableStatement cs = con.prepareCall(generateSpName(spNameParams))) {
				boolean hasResults = cs.execute();
		
				
				while (hasResults || cs.getUpdateCount() != -1 ) {
					if(hasResults) {
					System.out.println(cs.getResultSet());
					List<Map<String, Object>> resultSet = new ArrayList<>();
					try (ResultSet rs = cs.getResultSet()) {
						while (rs.next()) {
							Map<String, Object> row = new HashMap<>();
							ResultSetMetaData metaData = rs.getMetaData();
							int columnCount = metaData.getColumnCount();
							for (int i = 1; i <= columnCount; i++) {
								String columnName = metaData.getColumnName(i);
								Object columnValue = rs.getObject(i);
								row.put(columnName, columnValue);
							}
							resultSet.add(row);
						}
					}
					resultList.add(resultSet);
				}
					
					
					hasResults = cs.getMoreResults();
				}
 
			} catch (SQLException e) {
				e.printStackTrace();
			}
 
			return resultList;
		});
	}
 
}