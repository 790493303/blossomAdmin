package com.blossom.site.common.persistence.sql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 中文名注解
 * @author Blossom
 * @DateTime 2017/3/23 15:56
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface FieldName {

	String value();
	
}
