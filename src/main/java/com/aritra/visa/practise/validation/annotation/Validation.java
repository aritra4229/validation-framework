package com.aritra.visa.practise.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validation {
	public boolean mandatory() default false;
	public String regex() default "";
	public String[] allowedValues() default {};
	public int maxLength() default 0;
	public int minLength() default 0;
}
