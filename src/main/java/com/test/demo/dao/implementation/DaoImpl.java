package com.test.demo.dao.implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.demo.dao.interfaces.Dao;
import com.test.demo.utils.TempTables;








/* --------------------------THIS CLASS IMPLEMENTS THE INTERFACE DAO THAT----------------------------
 * HAS A METHOD execQueryResult THAT EXECUTES A BLOCK OF SQL CODE AND RETURNS ALL THE RESULTSETS	*/

@Repository
public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<List<Map<String, Object>>> execQueryResult(String sqlBlock) {
		if (!TempTables.aprt_imp_01) {/*CREATE THE TEMP TABLE*/
			/*TODO: IMPLEMENT A METHOD THAT CREATES TEMP TABLES THEN CALL IT HERE*/
		}
		return jdbcTemplate.execute((Connection con) -> {
			List<List<Map<String, Object>>> resultList = new ArrayList<>();
			try (PreparedStatement cs = con.prepareStatement(sqlBlock)) {
				boolean hasResults = cs.execute();
				while (hasResults || cs.getUpdateCount() != -1) {
					if (hasResults) {
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
						System.out.println("RESULTSET ADDED....");
					}
					hasResults = cs.getMoreResults();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("ALL THE RESULTSETS ARE ADDED SUCCESSFULLY....");
			return resultList;
		});
	}

}
