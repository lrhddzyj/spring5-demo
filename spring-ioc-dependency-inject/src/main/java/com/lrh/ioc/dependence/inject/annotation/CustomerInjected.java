package com.lrh.ioc.dependence.inject.annotation;

/**
 * 完全自主定义的依赖注入的注解
 */

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomerInjected {
}
