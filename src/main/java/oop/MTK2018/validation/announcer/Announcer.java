package oop.MTK2018.validation.announcer;

import oop.MTK2018.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

public abstract class Announcer {
    protected List<ValidationError> errors = new ArrayList<ValidationError>();

    public void addError(ValidationError e){
        errors.add(e);
    }

    public List<ValidationError> getErrors(){
        return errors;
    }

    public void clear(){
        errors.clear();
    }

    public abstract void announce();
}
