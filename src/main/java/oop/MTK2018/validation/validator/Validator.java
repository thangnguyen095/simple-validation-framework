package oop.MTK2018.validation.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.exception.UnsupportedDataType;

public abstract class Validator<T extends Annotation> {
    // check if the field is qualified for validation
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.isPrimitive() || c.equals(String.class); // only allow primitive types and string
    }

    public ValidationError validateField(Object o, T a, Field f) throws UnsupportedDataType {
        if(!verifyField(f)){
            throw new UnsupportedDataType("Unsupported data type for annotation: " + a.annotationType().getSimpleName());
        }

        return doValidate(o, f, a);
    }

    protected abstract ValidationError doValidate(Object o, Field f, T a);
}
