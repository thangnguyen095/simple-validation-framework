package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Range;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class RangeValidator extends Validator<Range>{
    @Override
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.equals(Integer.class);
    }

    @Override
    protected ValidationError doValidate(Object o, Field f, Range a) {
        String sVal = FieldExtractor.getValue(o, f);
        int iVal = Integer.parseInt(sVal);
        if(iVal < a.min() || iVal > a.max()){
            return new ValidationError(a.msg());
        }

        return null;
    }
}
