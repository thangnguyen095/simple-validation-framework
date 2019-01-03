package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Number;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class NumberValidator extends Validator<Number> {
    @Override
    protected ValidationError doValidate(Object o, Field f, Number a) {
        String sVal = FieldExtractor.getValue(o, f);
        try {
            Integer iVal = Integer.parseInt(sVal);
        }
        catch (NumberFormatException e)
        {
            return new ValidationError(a.msg());
        }
        return null;
    }
}
