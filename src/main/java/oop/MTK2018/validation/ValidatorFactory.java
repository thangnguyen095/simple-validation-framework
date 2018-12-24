package oop.MTK2018.validation;

import oop.MTK2018.validation.validator.Validator;

import java.lang.annotation.Annotation;
import java.util.HashMap;

public class ValidatorFactory {
    private static final ValidatorFactory instance = new ValidatorFactory();

    public static ValidatorFactory getInstance(){
        return instance;
    }

    private HashMap<Class<? extends Validator>, Validator> validators = new HashMap<Class<? extends Validator>, Validator>();

    public <T extends Annotation> Validator createValidator(Class<? extends Validator> c){
        if(validators.containsKey(c))
            return validators.get(c);

        Validator v;
        try {
             v = c.newInstance();
        } catch (Exception e) {
            return null;
        }

        validators.put(c, v);

        return v;
    }
}
