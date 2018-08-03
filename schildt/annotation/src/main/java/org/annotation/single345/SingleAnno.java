package org.annotation.single345;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by AOleynikov on 24.07.2018.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleAnno {
    int value();
}
