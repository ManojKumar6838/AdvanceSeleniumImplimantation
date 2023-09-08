package com.TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSONData {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis=new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\jsonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\jsonData.json"));
		JSONObject map=(JSONObject) obj;
		String url=map.get("url").toString();
		String un=map.get("un").toString();
		String pwd=map.get("pwd").toString();
		String browser=map.get("browser").toString();
		System.out.println(url);
		System.out.println(un);
		System.out.println(browser);
		System.out.println(pwd);
		
		
	}
	
}
