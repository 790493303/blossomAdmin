/**
 * Copyright &copy; 2015-2015  Jeedcp All rights reserved.
 */
package com.blossom.site.common.persistence.sql.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 * @author Blossom
 * @DateTime 2017/3/23 15:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {
	
	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a Spring bean in case of an autodetected component.
	 * @return the suggested component name, if any
	 */
	String value() default "";

}