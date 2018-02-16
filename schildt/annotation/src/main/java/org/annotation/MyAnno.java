package org.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention (RetentionPolicy.RUNTIME) 
public @interface MyAnno {
	String str() default "sdfsf";
	int val();
}
