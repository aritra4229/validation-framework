package com.aritra.visa.practise.validation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aritra.visa.practise.validation.annotation.Validation;
import com.aritra.visa.practise.validation.annotation.ValidationExtractor;
import com.aritra.visa.practise.validation.dto.Employee;
import com.aritra.visa.practise.validation.dto.ValidationError;
import com.aritra.visa.practise.validation.processor.ValidationProcessor;

@RestController

public class EmployeeController {
	
	@Autowired
	private ValidationExtractor extractor;
	
	@Autowired
	private ValidationProcessor processor;
	
	@PostMapping("/employee")
	public List<ValidationError> validateEmployee (@RequestBody Employee employee)
	{
		Map<String, Validation> map = extractor.validationExtractor(Employee.class);
		map.entrySet().stream().forEach(each->{
			System.out.println(each.getKey()+"-"+each.getValue().toString());
		});
		return processor.validate(employee, map);
	}
}
