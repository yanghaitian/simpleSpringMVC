package com.yht.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//定义方法的注释
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionMethod {
	public String value();
}