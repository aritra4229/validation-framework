package com.aritra.visa.practise.validation.validators;

import java.util.Objects;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.aritra.visa.practise.validation.dto.ValidationError;

@Component
public class MandatoryValidator {
	
	public ValidationError validateMandatoryField (JSONObject parentObj, String key)
	{
		String jsonKey = key;
		if(key.contains("."))
		{
			String keys[] = key.split("[.]");
			jsonKey = keys[keys.length-1];
		}
		
		if(parentObj!=null && parentObj.has(jsonKey)) {
			Object value = parentObj.get(jsonKey);
			if((value instanceof String && StringUtils.isEmpty((String)value))
					|| Objects.isNull(value))
			{
				return createValidationError(key);
			}
		}else {
			return createValidationError(key);
		}
		return null;
	}
	
	private ValidationError createValidationError (String key) {
		ValidationError error = new ValidationError();
		error.setErrorMessage(key+" is Mandatory");
		error.setErrorType("Mandatory Error");
		error.setFeildName(key);
		return error;
	}
}
