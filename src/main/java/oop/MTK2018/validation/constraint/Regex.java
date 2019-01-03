package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.RegexValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(RegexValidator.class)
public @interface Regex {
    String msg() default "Value does not match regex";
    String value();
}
