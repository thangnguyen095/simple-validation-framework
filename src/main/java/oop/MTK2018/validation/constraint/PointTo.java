package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.Validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PointTo {
    Class<? extends Validator> value();
}
