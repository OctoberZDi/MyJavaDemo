package com.example.springbootdemoaop.annotation;

import sun.awt.SunHints;

import java.lang.annotation.*;

/**
 * @author zhangdi03
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {
    String value() default "222";
}
