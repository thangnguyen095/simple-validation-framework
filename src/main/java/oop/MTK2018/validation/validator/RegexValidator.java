package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Regex;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator extends Validator<Regex> {
    @Override
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.equals(String.class); // only check on String
    }

    @Override
    protected ValidationError doValidate(Object o, Field f, Regex a) {
        String val = FieldExtractor.getValue(o, f);
        String reg = a.value();
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(val);
        if(m.matches()) // match regex
            return null;

        return new ValidationError(a.msg()); // does not match regex
    }
}
