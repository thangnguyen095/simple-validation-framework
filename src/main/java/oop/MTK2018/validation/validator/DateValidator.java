package oop.MTK2018.validation.validator;

import oop.MTK2018.validation.ValidationError;
import oop.MTK2018.validation.constraint.Date;
import oop.MTK2018.validation.util.FieldExtractor;

import java.lang.reflect.Field;

public class DateValidator extends Validator<Date> {
    @Override
    protected boolean verifyField(Field f){
        Class c = f.getType();
        return c.equals(String.class);
    }

    @Override
    protected ValidationError doValidate(Object o, Field f, Date a) {
        String val = FieldExtractor.getValue(o, f);

        int day = Integer.parseInt(val.substring(0, 2));
        int month = Integer.parseInt(val.substring(3, 5));
        int year = Integer.parseInt(val.substring(6, 8));

//        if (year % 4 == 0 && year % 100 != 0) {
//            int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        }
//        else {
//            int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        }
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(val.length() != 8){
            return new ValidationError(a.msg());
        }
        else if (val.charAt(2) != val.charAt(5) || val.charAt(2) != '-' || val.charAt(2) != '/')
        {
            return new ValidationError(a.msg());
        }
        else if (!(month >= 1 && month <= 12) || !(year >= 1900 && year <= 2100))
        {
            return new ValidationError(a.msg());
        }
        else if (!(day >= 1 && day <= days[month - 1]))
        {
            return new ValidationError(a.msg());
        }

        return null;
    }
}
