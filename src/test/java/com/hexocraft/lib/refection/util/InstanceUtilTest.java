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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class InstanceUtilTest {

    @Test
    void newInstance() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        OuterClass outerClass = InstanceUtil.newInstance(OuterClass.class);
        OuterClass outerStringClass = InstanceUtil.newInstance(OuterClass.class, String.class, "This is my value");
        OuterClass outerIntClass = InstanceUtil.newInstance(OuterClass.class, int.class, 10);

        List<Class<?>> stringType = new ArrayList<Class<?>>() {{
            add(String.class);
        }};

        List<Object> stringArg = new ArrayList<Object>() {{
            add("This is my value");
        }};

        OuterClass outerStringListClass = InstanceUtil.newInstance(OuterClass.class, stringType, stringArg);

        List<Class<?>> intStringType = new ArrayList<Class<?>>() {{
            add(int.class);
            add(String.class);
        }};

        List<Object> intStringArg = new ArrayList<Object>() {{
            add(10);
            add("This is my value");
        }};

        OuterClass outerIntStringListClass = InstanceUtil.newInstance(OuterClass.class, intStringType, intStringArg);
    }

    @Test
    void newInstanceSilent() {

        assertNotNull(InstanceUtil.newInstanceSilent(OuterClass.class));
        assertNotNull(InstanceUtil.newInstanceSilent(OuterClass.class, String.class, "This is my value"));
        assertNotNull(InstanceUtil.newInstanceSilent(OuterClass.class, int.class, 10));

        List<Class<?>> stringType = new ArrayList<Class<?>>() {{
            add(String.class);
        }};

        List<Object> stringArg = new ArrayList<Object>() {{
            add("This is my value");
        }};

        assertNotNull(InstanceUtil.newInstanceSilent(OuterClass.class, stringType, stringArg));

        List<Class<?>> intStringType = new ArrayList<Class<?>>() {{
            add(int.class);
            add(String.class);
        }};

        List<Object> intStringArg = new ArrayList<Object>() {{
            add(10);
            add("This is my value");
        }};

        assertNotNull(InstanceUtil.newInstanceSilent(OuterClass.class, intStringType, intStringArg));

    }
}
