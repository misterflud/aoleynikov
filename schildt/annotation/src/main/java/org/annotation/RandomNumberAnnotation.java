package org.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention (RetentionPolicy.RUNTIME) 
public @interface RandomNumberAnnotation {
	int min();
	int max();
	
	
}
