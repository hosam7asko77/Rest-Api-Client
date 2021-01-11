package com.hit;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MysqlDemo {
	

	public static void main(String[] args) throws ParseException {

		MysqlOpertion opertion = new MysqlOpertion();
		try {
			int data = opertion.insertData(1, "savane", 32, 90, "firstClass");
			 System.out.println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<Date> dates=new ArrayList<>();
//		List<String> list=new ArrayList<String>();
//		list.add("15.10.2012");
//		list.add("15.9.2012");
//		list.add("15.8.2012");
//		list.add("15.7.2012");
//		list.add("15.6.2012");
//		String string ="15.11.2012";
//		   Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(string);  
//		    System.out.println(string+"\t"+date1);  
//		for (String string2 : list) {
//			   Date date=new SimpleDateFormat("dd.MM.yyyy").parse(string2);  
//			   System.out.println(string2+"\t"+date);
//			   dates.add(date);
//		}
//		  Calendar c=Calendar.getInstance();
//		    c.setTime(date1);
//		    c.add(Calendar.MONTH, -4);
//		    
//		    System.out.println(c.getTime());
 	}

}
