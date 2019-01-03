package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.RangeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(RangeValidator.class)

public @interface Range {
    String msg() default "Number is not in range";

    int min();
    int max();
}
