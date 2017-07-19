package com.example.demo.util;

import com.example.demo.model.CoreTeacherSearchIndex;
import org.junit.Test;

/**
 * Created by Ido on 2017/7/19.
 */
public class TestStringUtil {
    @Test
    public void testgetAttrSqlString(){

        StringUtil.println(StringUtil.getAttrSqlString(CoreTeacherSearchIndex.class,"ctsi"));
    }
}
