package oop.MTK2018.validation.constraint;


import oop.MTK2018.validation.validator.MinimumLengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(MinimumLengthValidator.class)
public @interface MinimumLength {
    String msg() default "Does not meet required length";
    int min();
}
