package com.aritra.visa.practise.validation.util;

import org.json.JSONObject;

public class JsonUtil {
	
	public static JSONObject extractParentJsonObject (JSONObject root, String key) {
		String path[] = key.split("[.]");
		JSONObject parentObject = root;
		for (int i =0; i<path.length-1; i++)
		{
			if(parentObject.has(path[i]))
			{
				parentObject = parentObject.getJSONObject(path[i]);
			}
			else 
			{
				return null;
			}
		}
		return parentObject;
	}
}
