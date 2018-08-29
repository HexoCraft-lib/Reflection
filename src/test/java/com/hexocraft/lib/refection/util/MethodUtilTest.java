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

import com.hexocraft.lib.reflection.util.MethodUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


class MethodUtilTest {

    @Test
    void getMethod() throws NoSuchMethodException {

        Method getData = MethodUtil.getMethod(OuterClass.class, "getData");
        Method getValue = MethodUtil.getMethod(OuterClass.class, "getValue");
        Method setData = MethodUtil.getMethod(OuterClass.class, "setData", int.class);
        Method setValue = MethodUtil.getMethod(OuterClass.class, "setValue", String.class);
        Method setDataValue = MethodUtil.getMethod(OuterClass.class, "setDataValue", int.class, String.class);
    }

    @Test
    void getMethodSilent() {

        assertNotNull(MethodUtil.getMethodSilent(OuterClass.class, "getData"));
        assertNotNull(MethodUtil.getMethodSilent(OuterClass.class, "getValue"));
        assertNotNull(MethodUtil.getMethodSilent(OuterClass.class, "setData", int.class));
        assertNotNull(MethodUtil.getMethodSilent(OuterClass.class, "setValue", String.class));
        assertNotNull(MethodUtil.getMethodSilent(OuterClass.class, "setDataValue", int.class, String.class));

        assertNull(MethodUtil.getMethodSilent(OuterClass.class, "myMethos"));
        assertNull(MethodUtil.getMethodSilent(OuterClass.class, "myMethos", int.class));
        assertNull(MethodUtil.getMethodSilent(OuterClass.class, "myMethos", String.class));
        assertNull(MethodUtil.getMethodSilent(OuterClass.class, "myMethos", int.class, String.class));
    }

    @Test
    void hasMethod() throws NoSuchMethodException {

        boolean getData = MethodUtil.hasMethod(OuterClass.class, "getData");
        boolean getValue = MethodUtil.hasMethod(OuterClass.class, "getValue");
        boolean setData = MethodUtil.hasMethod(OuterClass.class, "setData", int.class);
        boolean setValue = MethodUtil.hasMethod(OuterClass.class, "setValue", String.class);
        boolean setDataValue = MethodUtil.hasMethod(OuterClass.class, "setDataValue", int.class, String.class);
    }

    @Test
    void hasMethodSilent() {

        assertTrue(MethodUtil.hasMethodSilent(OuterClass.class, "getData"));
        assertTrue(MethodUtil.hasMethodSilent(OuterClass.class, "getValue"));
        assertTrue(MethodUtil.hasMethodSilent(OuterClass.class, "setData", int.class));
        assertTrue(MethodUtil.hasMethodSilent(OuterClass.class, "setValue", String.class));
        assertTrue(MethodUtil.hasMethodSilent(OuterClass.class, "setDataValue", int.class, String.class));
    }

    @Test
    void invokeMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        OuterClass outerClass = new OuterClass(10, "This is my value");

        Method getData = MethodUtil.getMethod(OuterClass.class, "getData");
        Method getValue = MethodUtil.getMethod(OuterClass.class, "getValue");
        Method setData = MethodUtil.getMethod(OuterClass.class, "setData", int.class);
        Method setValue = MethodUtil.getMethod(OuterClass.class, "setValue", String.class);
        Method setDataValue = MethodUtil.getMethod(OuterClass.class, "setDataValue", int.class, String.class);

        assertEquals((int) MethodUtil.invokeMethod(getData, outerClass), (int) 10);
        assertEquals((String) MethodUtil.invokeMethod(getValue, outerClass), (String) "This is my value");

        MethodUtil.invokeMethod(setData, outerClass, 20);
        MethodUtil.invokeMethod(setValue, outerClass, "This is an other value");

        assertEquals((int) MethodUtil.invokeMethod(getData, outerClass), (int) 20);
        assertEquals((String) MethodUtil.invokeMethod(getValue, outerClass), (String) "This is an other value");

        MethodUtil.invokeMethod(setDataValue, outerClass, 30, "This is an other other value");

        assertEquals((int) MethodUtil.invokeMethod(getData, outerClass), (int) 30);
        assertEquals((String) MethodUtil.invokeMethod(getValue, outerClass), (String) "This is an other other value");
    }

    @Test
    void invokeMethodSilent() {

        OuterClass outerClass = new OuterClass(10, "This is my value");

        Method getData = MethodUtil.getMethodSilent(OuterClass.class, "getData");
        Method getValue = MethodUtil.getMethodSilent(OuterClass.class, "getValue");
        Method setData = MethodUtil.getMethodSilent(OuterClass.class, "setData", int.class);
        Method setValue = MethodUtil.getMethodSilent(OuterClass.class, "setValue", String.class);
        Method setDataValue = MethodUtil.getMethodSilent(OuterClass.class, "setDataValue", int.class, String.class);

        assertEquals((int) MethodUtil.invokeMethodSilent(getData, outerClass), (int) 10);
        assertEquals((String) MethodUtil.invokeMethodSilent(getValue, outerClass), (String) "This is my value");

        MethodUtil.invokeMethodSilent(setData, outerClass, 20);
        MethodUtil.invokeMethodSilent(setValue, outerClass, "This is an other value");

        assertEquals((int) MethodUtil.invokeMethodSilent(getData, outerClass), (int) 20);
        assertEquals((String) MethodUtil.invokeMethodSilent(getValue, outerClass), (String) "This is an other value");

        MethodUtil.invokeMethodSilent(setDataValue, outerClass, 30, "This is an other other value");

        assertEquals((int) MethodUtil.invokeMethodSilent(getData, outerClass), (int) 30);
        assertEquals((String) MethodUtil.invokeMethodSilent(getValue, outerClass), (String) "This is an other other value");
    }
}
