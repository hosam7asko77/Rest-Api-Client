package com.hit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlOpertion {

	private MysqlConectionDrive drive;
	
	
	public MysqlOpertion() {
		drive=new MysqlConectionDrive();
	}


	public int insertData(int id,String name, int age, int result, String cla) throws SQLException {
		Connection con = MysqlConectionDrive.getCon();
		PreparedStatement prepared=con.prepareStatement("INSERT INTO student (id, name, age, result, class) VALUES (?, ?, ?, ?, ?)");
		prepared.setInt(1, id);
		prepared.setString(2, name);
		prepared.setInt(3, age);
		prepared.setInt(4, result);
		prepared.setString(5, cla);
		int execute = prepared.executeUpdate();	
		drive.closeCon();
		return execute;  
		
		
	}
	
}
