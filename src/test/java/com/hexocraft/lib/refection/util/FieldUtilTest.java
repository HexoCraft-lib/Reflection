package com.hexocraft.lib.refection.util;

/*

 Copyright 2018 hexosse

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FieldUtilTest {

    OuterClass outerClass = new OuterClass(10, "This is my value");

    @Test
    void getField() throws NoSuchFieldException, IllegalAccessException {

        //getField(Class<?> clazz, String name)
        FieldUtil.getField(OuterClass.class, "data");

        //getField(Class<?> clazz, String name, Object from)
        assertEquals((int) FieldUtil.getField(OuterClass.class, "data", outerClass), (int) 10);
        assertEquals((String) FieldUtil.getField(OuterClass.class, "value", outerClass), (String) "This is my value");

        //getField(Field field, Object from)
        Field data = FieldUtil.getField(OuterClass.class, "data");
        Field value = FieldUtil.getField(OuterClass.class, "value");
        assertEquals((int) FieldUtil.getField(data, outerClass), (int) 10);
        assertEquals((String) FieldUtil.getField(value, outerClass), (String) "This is my value");

        //getField(String name, Object from)
        assertEquals((int) FieldUtil.getField("data", outerClass), (int) 10);
        assertEquals((String) FieldUtil.getField("value", outerClass), (String) "This is my value");

        assertThrows(NoSuchFieldException.class, () -> FieldUtil.getField(OuterClass.class, "error"));
    }

    @Test
    void getFieldSilent() {

        //getFieldSilent(Class<?> clazz, String name)
        FieldUtil.getFieldSilent(OuterClass.class, "data");

        //getFieldSilent(Class<?> clazz, String name, Object from)
        assertEquals((int) FieldUtil.getFieldSilent(OuterClass.class, "data", outerClass), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent(OuterClass.class, "value", outerClass), (String) "This is my value");

        //getFieldSilent(Field field, Object from)
        Field data = FieldUtil.getFieldSilent(OuterClass.class, "data");
        Field value = FieldUtil.getFieldSilent(OuterClass.class, "value");
        assertEquals((int) FieldUtil.getFieldSilent(data, outerClass), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent(value, outerClass), (String) "This is my value");

        //getFieldSilent(String name, Object from)
        assertEquals((int) FieldUtil.getFieldSilent("data", outerClass), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClass), (String) "This is my value");
    }

    @Test
    void setField() throws IllegalAccessException {

        Field data = FieldUtil.getFieldSilent(OuterClass.class, "data");
        Field value = FieldUtil.getFieldSilent(OuterClass.class, "value");

        //setField(Field field, Object object, Object value)
        FieldUtil.setField(data, outerClass, 20);
        FieldUtil.setField(value, outerClass, "This is an other value");

        assertEquals((int) FieldUtil.getFieldSilent("data", outerClass), (int) 20);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClass), (String) "This is an other value");
    }

    @Test
    void transferFields() throws NoSuchFieldException, IllegalAccessException {

        OuterClass outerClassEmpty;

        //transferField(Class<?> clazz, Object from, Object to, String name)
        outerClassEmpty = new OuterClass();
        FieldUtil.transferField(OuterClass.class, outerClass, outerClassEmpty, "data");
        FieldUtil.transferField(OuterClass.class, outerClass, outerClassEmpty, "value");
        assertEquals((int) FieldUtil.getFieldSilent("data", outerClassEmpty), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClassEmpty), (String) "This is my value");

        //transferFields(Class<?> clazz, Object from, Object to, String... fieldNames)
        outerClassEmpty = new OuterClass();
        FieldUtil.transferFields(OuterClass.class, outerClass, outerClassEmpty, "data", "value");
        assertEquals((int) FieldUtil.getFieldSilent("data", outerClassEmpty), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClassEmpty), (String) "This is my value");

        //transferFields(Class<?> clazz, Object from, Object to, List<String> fieldNames)
        outerClassEmpty = new OuterClass();
        List<String> fieldNames = new ArrayList<String>() {{
            add("data");
            add("value");
        }};
        FieldUtil.transferFields(OuterClass.class, outerClass, outerClassEmpty, fieldNames);
        assertEquals((int) FieldUtil.getFieldSilent("data", outerClassEmpty), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClassEmpty), (String) "This is my value");

        //transferFields(Class<?> clazz, Object from, Object to)
        outerClassEmpty = new OuterClass();
        FieldUtil.transferFields(OuterClass.class, outerClass, outerClassEmpty);
        assertEquals((int) FieldUtil.getFieldSilent("data", outerClassEmpty), (int) 10);
        assertEquals((String) FieldUtil.getFieldSilent("value", outerClassEmpty), (String) "This is my value");
    }
}
