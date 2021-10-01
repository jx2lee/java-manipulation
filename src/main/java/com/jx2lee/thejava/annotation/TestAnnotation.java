package com.jx2lee.thejava.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited()
public @interface TestAnnotation {
    String name() default "jaejun";
}
