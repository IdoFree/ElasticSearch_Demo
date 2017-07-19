package com.example.demo.util;

import com.example.demo.model.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ido on 2017/7/19.
 */
public class TestObjectUtils {
    @Test
    public void testFillProperties() throws IllegalAccessException {
        Teacher teacher = new Teacher();
        Object[] pros = new Object[4];
        pros[0] = 18;
        pros[1] = "ido";
        pros[2] = "male";
        pros[3] = 1;

        StringUtil.println(ObjectUtils.fillProperties(teacher,pros).toString());
    }
}
