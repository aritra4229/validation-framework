package com.aritra.visa.practise.validation.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.aritra.visa.practise.validation.annotation.Validation;
import com.aritra.visa.practise.validation.dto.ValidationError;
import com.aritra.visa.practise.validation.util.JsonUtil;
import com.aritra.visa.practise.validation.validators.MandatoryValidator;

@Component
public class ValidationProcessor {
	
	@Autowired
	private MandatoryValidator mandatoryValidator;
	
	public List<ValidationError> validate (Object payload, Map<String, Validation> validationRules)
	{
		List<ValidationError> errors = new ArrayList<>();
		JSONObject jsonObject = new JSONObject(payload);
		for (Map.Entry<String,Validation> eachRuleEntry : validationRules.entrySet()){
			if(eachRuleEntry.getKey().contains("."))
			{
				jsonObject = JsonUtil.extractParentJsonObject(jsonObject, eachRuleEntry.getKey());
			}
			
			if(eachRuleEntry.getValue().mandatory()) {
				ValidationError error = mandatoryValidator.validateMandatoryField(jsonObject, eachRuleEntry.getKey());
				if(error!=null)
				{
					errors.add(error);
				}
			}
		}
		return errors;
	}
}
