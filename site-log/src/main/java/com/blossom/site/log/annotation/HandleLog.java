package com.blossom.site.log.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/24 16:04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface HandleLog {

    String description() default "";

    String tableName() default "";

}
