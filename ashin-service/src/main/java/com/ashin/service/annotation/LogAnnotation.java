package com.ashin.service.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 * Created by Administrator on 2019/11/7.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    String value() default "";

}
































