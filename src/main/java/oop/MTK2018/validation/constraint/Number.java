package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.NumberValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(NumberValidator.class)

public @interface Number {
    String msg() default "Please enter a number";
}
