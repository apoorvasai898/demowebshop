package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException
	{
		String result = "";
		FileInputStream fis = new FileInputStream(".\\configAppData\\demowebshopcommondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		result = prop.getProperty(key);
		return result;
	}

}
