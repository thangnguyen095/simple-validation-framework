package oop.MTK2018.validation.constraint;

import oop.MTK2018.validation.validator.NotNullValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PointTo(NotNullValidator.class)
public @interface NotNull {
    String msg() default "Cannot be null";
}
