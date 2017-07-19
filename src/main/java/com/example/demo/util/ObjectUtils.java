package com.example.demo.util;

import java.lang.reflect.Field;

/**
 * Created by Ido on 2017/7/19.
 */
public class ObjectUtils {
    public static Object fillProperties(Object target, Object[] vals) throws IllegalAccessException {
        Field[] fs = target.getClass().getDeclaredFields();
        for(int i = 0 ; i< vals.length; i++){
            fs[i].setAccessible(true);
            fs[i].set(target,vals[i]);
        }
        return  target;

    }
}
