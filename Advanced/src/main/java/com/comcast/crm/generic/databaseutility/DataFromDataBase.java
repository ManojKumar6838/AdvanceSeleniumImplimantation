package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataFromDataBase {

	public ResultSet readDatabase(String query) throws Throwable {
		Connection conn = null;
		ResultSet result = null;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("", "", "");
		Statement stat=conn.createStatement();
		result=stat.executeQuery(query);
		}
		catch(Exception e) {
			
		}
		finally {
			conn.close();
		}
		
		return result;
		
		
	}
}
