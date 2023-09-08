package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadDataPropertiesFile {

	
	public String readDataProperties(String key)throws Throwable {
		FileInputStream fis=new FileInputStream("./testConfigruation/CommenData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}  
}
