package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilty {

	public int generateRandomNum() {
		Random ran=new Random();
		int num=ran.nextInt(1000);
		return num;
	}
	
	public String getSystemDate(String format){
		Date date= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		String actualDate=sdf.format(date);
		return actualDate;	
	}
	
	public String getReqDate(int days, String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date date=cal.getTime();
		String reqDate=sdf.format(date);
		return reqDate;
		//System.out.println(reqDate);
	}
}
