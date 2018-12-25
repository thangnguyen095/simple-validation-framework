package oop.MTK2018.validation.util;

import java.lang.reflect.Field;

public class FieldExtractor {
    public static String getValue(Object o, Field f) {
        f.setAccessible(true);
        String res = null;
        try {
            res = f.get(o).toString();
        } catch (Exception e){
            // var is undefined
        }
        return res;
    }
}
