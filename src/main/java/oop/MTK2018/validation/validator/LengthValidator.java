package oop.MTK2018.validation.validator;


import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Length;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class LengthValidator extends Validator<Length> {

    @Override
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.equals(String.class);
    }

    @Override
    protected ValidationError doValidate(Object o, Field f, Length a) {
        String val = FieldExtractor.getValue(o, f);
        if(val.length() < a.min()){
            return new ValidationError(a.msg());
        }

        return null;
    }
}
