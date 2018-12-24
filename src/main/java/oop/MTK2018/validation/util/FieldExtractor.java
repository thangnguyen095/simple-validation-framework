package oop.MTK2018.validation.util;

import java.lang.reflect.Field;

public class FieldExtractor {
    public static String getValue(Object o, Field f) throws IllegalAccessException {
        f.setAccessible(true);
        String res = (String)f.get(o);
        return res;
    }
}
