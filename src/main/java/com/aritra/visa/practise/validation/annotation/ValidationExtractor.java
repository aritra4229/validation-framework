package com.aritra.visa.practise.validation.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ValidationExtractor {
	
	public Map<String, Validation> validationExtractor (Class clazz)
	{
		Map<String, Validation> validationMap = new HashMap<>();
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields)
		{
			if(field.isAnnotationPresent(Validation.class))
			{
				Validation validation = field.getAnnotation(Validation.class);
				validationMap.put(field.getName(), validation);
			}
			if(!field.getType().isPrimitive())
			{
				Map<String, Validation> childValiationMap = validationExtractor(field.getType());
				if(!childValiationMap.isEmpty())
				{
					childValiationMap.entrySet().stream().forEach(entry->{
						validationMap.put(field.getName()+"."+entry.getKey(), entry.getValue());
					});
				}
			}
		}
		return validationMap;
	}
}
