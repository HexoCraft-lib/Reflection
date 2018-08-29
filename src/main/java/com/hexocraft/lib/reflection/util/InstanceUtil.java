package com.hexocraft.lib.reflection.util;

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

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.hexocraft.lib.reflection.util.ConstructorUtil.*;


public class InstanceUtil {

    private InstanceUtil() {
        throw new IllegalAccessError("This is a private constructor Use static functions instead.");
    }

    /**
     * @param clazz Class containing the constructor
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     *         control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     *         abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T newInstance(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(getConstructor(clazz));
    }

    /**
     * @param clazz Class containing the constructor
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T newInstanceSilent(Class<?> clazz) {
        return invokeConstructorSilent(getConstructorSilent(clazz));
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     * @param argument object to be passed as argument to the constructor call; values of primitive types are
     *         wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link java.lang.Float
     *         Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     *         control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     *         abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T newInstance(Class<?> clazz, Class<?> parameterType, Object argument) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(getConstructor(clazz, parameterType), argument);
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     * @param argument object to be passed as argument to the constructor call; values of primitive types are
     *         wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link java.lang.Float
     *         Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T newInstanceSilent(Class<?> clazz, Class<?> parameterType, Object argument) {
        return invokeConstructorSilent(getConstructorSilent(clazz, parameterType), argument);
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     * @param arguments array of objects to be passed as arguments to the constructor call; values of primitive
     * types are wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link
     * java.lang.Float Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     *         control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     *         abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T newInstance(Class<?> clazz, List<Class<?>> parameterTypes, List<Object> arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(
            getConstructor(clazz, parameterTypes.toArray(new Class<?>[0]))
            , arguments.toArray(new Object[0]));
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     * @param arguments array of objects to be passed as arguments to the constructor call; values of primitive
     * types are wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link
     * java.lang.Float Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T newInstanceSilent(Class<?> clazz, List<Class<?>> parameterTypes, List<Object> arguments) {
        return invokeConstructorSilent(
            getConstructorSilent(clazz, parameterTypes.toArray(new Class<?>[0]))
            , arguments.toArray(new Object[0]));
    }
}
