package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.NotNull;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class NotNullValidator extends Validator<NotNull>{

    protected ValidationError doValidate(Object o, Field f, NotNull a){
        String val = FieldExtractor.getValue(o, f);
        if(val == null || val.isEmpty()){
            return new ValidationError(a.msg());
        }
        return null;
    }

}
