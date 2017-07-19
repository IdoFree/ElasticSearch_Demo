package com.example.demo.util;

import java.lang.reflect.Field;

/**
 * Created by Ido on 2017/7/19.
 */
public class StringUtil {
    public static String  getAttrSqlString(Class clz,String alias){
        StringBuilder sb = new StringBuilder();
        Field[] fs = clz.getDeclaredFields();
        sb.append("\" ");
        for(Field f : fs){
            sb.append(alias).append(".").append(f.getName()).append(" ,");
        }
        sb.append("\" ");

        return sb.toString();
    }

    public static void println(String s ){
        System.out.println(s);

    }
}
