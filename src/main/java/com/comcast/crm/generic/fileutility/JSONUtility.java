package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJSONFile(String key) throws IOException, ParseException
	{
		String result = "";
		JSONParser parser = new JSONParser();
		FileReader fis = new FileReader("./VTiger_CommonData.json");
		Object obj = parser.parse(fis);
		JSONObject jsonObj = (JSONObject)obj;
		result = jsonObj.get(key).toString();
		return result;
		
	}

}
