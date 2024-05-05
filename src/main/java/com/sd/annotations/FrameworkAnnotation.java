package com.sd.annotations;

import com.sd.enums.AuthorType;
import com.sd.enums.CategoriesType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {
    public AuthorType[] author();
    public CategoriesType[] category();
}
