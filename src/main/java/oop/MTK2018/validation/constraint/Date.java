package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.DateValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(DateValidator.class)

public @interface Date {
    String msg() default "Please enter a date (ex: \"04/01/2019\" or \"04-01-2019\")";
}
