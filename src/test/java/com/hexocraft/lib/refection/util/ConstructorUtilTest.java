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

import com.hexocraft.lib.reflection.util.ConstructorUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class ConstructorUtilTest {

    @Test
    void getConstructor() throws NoSuchMethodException, ClassNotFoundException {

        // Outer class
        Constructor outerEmptyConstructor = ConstructorUtil.getConstructor(OuterClass.class);
        Constructor outerStringConstructor = ConstructorUtil.getConstructor(OuterClass.class, String.class);
        Constructor outerIntConstructor = ConstructorUtil.getConstructor(OuterClass.class, int.class);
        Constructor outerIntStringConstructor = ConstructorUtil.getConstructor(OuterClass.class, int.class, String.class);
        Constructor outerStringValueConstructor = ConstructorUtil.getConstructor(OuterClass.class, (String) "This is my value");
        //Constructor outerIntStringValueConstructor = ConstructorUtil.getConstructor(OuterClass.class, (int) 10, (String) "This is my value");

        // static inner class
        Constructor innerEmptyConstructor = ConstructorUtil.getConstructor(Class.forName("com.hexocraft.lib.refection.util.OuterClass$innerClass"));
        Constructor innerStringConstructor = ConstructorUtil.getConstructor(Class.forName("com.hexocraft.lib.refection.util.OuterClass$innerClass"), String.class);
        Constructor innerStringValueConstructor = ConstructorUtil.getConstructor(Class.forName("com.hexocraft.lib.refection.util.OuterClass$innerClass"), (String) "This is my value");
    }

    @Test
    void getConstructorSilent() {

        // Outer class
        assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class));
        assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class, String.class));
        assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class, int.class));
        assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class, int.class, String.class));
        assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class, (String) "This is my value"));
        //assertNotNull(ConstructorUtil.getConstructorSilent(OuterClass.class, (int) 10, (String) "This is my value"));
    }

    @Test
    void invokeConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        OuterClass outerClass = ConstructorUtil.invokeConstructor(ConstructorUtil.getConstructor(OuterClass.class));
        OuterClass outerStringClass = ConstructorUtil.invokeConstructor(ConstructorUtil.getConstructor(OuterClass.class, String.class), "This is my value");
        OuterClass outerIntStringClass = ConstructorUtil.invokeConstructor(ConstructorUtil.getConstructor(OuterClass.class, int.class, String.class), 10, "This is my value");
    }

    @Test
    void invokeConstructorSilent() {

        OuterClass outerClass = ConstructorUtil.invokeConstructorSilent(ConstructorUtil.getConstructorSilent(OuterClass.class));
        OuterClass outerStringClass = ConstructorUtil.invokeConstructorSilent(ConstructorUtil.getConstructorSilent(OuterClass.class, String.class), "This is my value");
        OuterClass outerIntStringClass = ConstructorUtil.invokeConstructorSilent(ConstructorUtil.getConstructorSilent(OuterClass.class, int.class, String.class), 10, "This is my value");
    }
}
