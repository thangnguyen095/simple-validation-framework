package oop.MTK2018.validation;

import oop.MTK2018.validation.announcer.Announcer;
import oop.MTK2018.validation.constraint.NotNull;
import oop.MTK2018.validation.constraint.PointTo;
import oop.MTK2018.validation.exception.UnsupportedDataType;
import oop.MTK2018.validation.validator.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validation {
    public Validation(Announcer a){
        announcer = a;
    }

    private Announcer announcer;
    
    public void setAnnouncer(Announcer a){
        announcer = a;
    }

    public boolean validate(Object o) throws IllegalAccessException, UnsupportedDataType {
        announcer.clear(); // reset announcer
        // get all fields in the class
        Class c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field f: fields){
            validate(o, f); // validate each fields
        }
        if(announcer.getErrors().size() == 0)
            return true;
        announcer.announce(); // announce errors
        return false;
    }

    private void validate(Object o, Field f) throws IllegalAccessException, UnsupportedDataType {
        ValidatorFactory factory = ValidatorFactory.getInstance();
        // get all annotations on each field
        Annotation[] annotations = f.getDeclaredAnnotations();
        for(Annotation a: annotations){
            // check if the annotation belongs to validator
            PointTo pt = a.annotationType().getDeclaredAnnotation(PointTo.class);
            if(pt == null){
                // not validator
                // skip
                break;
            }

            Class validatorClass = pt.value();
            Validator validator = factory.createValidator(validatorClass);
            ValidationError e = validator.validateField(o, a, f);
            if(e != null)
                announcer.addError(e);
        }
    }
}
