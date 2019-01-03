package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Number;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class NumberValidator extends Validator<Number> {
    @Override
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.equals(Integer.class);
    }

    @Override
    protected ValidationError doValidate(Object o, Field f, Number a) {
        if(!verifyField(f)){
            return new ValidationError(a.msg());
        }

        return null;
    }
}
