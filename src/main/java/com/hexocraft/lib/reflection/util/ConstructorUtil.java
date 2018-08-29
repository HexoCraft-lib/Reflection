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

import org.inventivetalent.reflection.resolver.ConstructorResolver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Helper class to get constructor
 */
@SuppressWarnings("WeakerAccess")
public class ConstructorUtil {

    private static final Class<?>[] EMPTY_CLASS_ARRAY  = new Class<?>[0];
    private static final Object[]   EMPTY_OBJECT_ARRAY = new Object[0];

    private ConstructorUtil() {
        throw new IllegalAccessError("This is a private constructor Use static functions instead.");
    }


    //--- getConstructor -------------------------------------------------------

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static <T> Constructor<T> getConstructor(Class<?> clazz, Class<?>... parameterTypes)
        throws NoSuchMethodException {
        return (Constructor<T>) new ConstructorResolver(clazz).resolve(parameterTypes);
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static <T> Constructor<T> getConstructorSilent(Class<?> clazz, Class<?>... parameterTypes) {
        return (Constructor<T>) new ConstructorResolver(clazz).resolveSilent(parameterTypes);
    }

    /**
     * @param clazz Class containing the constructor
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static <T> Constructor<T> getConstructor(Class<?> clazz) throws NoSuchMethodException {
        return getConstructor(clazz, EMPTY_CLASS_ARRAY);
    }

    /**
     * @param clazz Class containing the constructor
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static <T> Constructor<T> getConstructorSilent(Class<?> clazz) {
        return getConstructorSilent(clazz, EMPTY_CLASS_ARRAY);
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static <T> Constructor<T> getConstructor(Class<?> clazz, Class<?> parameterType)
        throws NoSuchMethodException {
        return (Constructor<T>) new ConstructorResolver(clazz).resolve(new Class[] {parameterType});
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static <T> Constructor<T> getConstructorSilent(Class<?> clazz, Class<?> parameterType) {
        return (Constructor<T>) new ConstructorResolver(clazz).resolveSilent(new Class[] {parameterType});
    }

    /**
     * @param clazz Class containing the constructor
     * @param args array of objects to define the list of parameters
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static <T> Constructor<T> getConstructor(Class<?> clazz, Object... args) throws NoSuchMethodException {

        Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
        return getConstructor(clazz, parameterTypes);
    }

    /**
     * @param clazz Class containing the constructor
     * @param args array of objects to define the list of parameters
     * @param <T> Class type
     *
     * @return the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static <T> Constructor<T> getConstructorSilent(Class<?> clazz, Object... args) {

        Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
        return getConstructorSilent(clazz, parameterTypes);
    }


    //--- hasConstructor -------------------------------------------------------

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static boolean hasConstructor(Class<?> clazz, Class<?>... parameterTypes) throws NoSuchMethodException {
        getConstructor(clazz, parameterTypes);
        return true;
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterTypes the list of parameters
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static boolean hasConstructorSilent(Class<?> clazz, Class<?>... parameterTypes) {
        return getConstructorSilent(clazz, parameterTypes) != null;
    }

    /**
     * @param clazz Class containing the constructor
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static boolean hasConstructor(Class<?> clazz) throws NoSuchMethodException {
        getConstructor(clazz);
        return true;
    }

    /**
     * @param clazz Class containing the constructor
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static boolean hasConstructorSilent(Class<?> clazz) {
        return getConstructorSilent(clazz) != null;
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static boolean hasConstructor(Class<?> clazz, Class<?> parameterType) throws NoSuchMethodException {
        getConstructor(clazz, parameterType);
        return true;
    }

    /**
     * @param clazz Class containing the constructor
     * @param parameterType the parameter
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static boolean hasConstructorSilent(Class<?> clazz, Class<?> parameterType) {
        return getConstructorSilent(clazz, parameterType) != null;
    }

    /**
     * @param clazz Class containing the constructor
     * @param args array of objects to define the list of parameters
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     *
     * @throws NoSuchMethodException If not exist in {@code clazz}
     */
    public static boolean hasConstructor(Class<?> clazz, Object... args) throws NoSuchMethodException {
        getConstructor(clazz, args);
        return true;
    }

    /**
     * @param clazz Class containing the constructor
     * @param args array of objects to define the list of parameters
     *
     * @return true if the {@code Constructor} that matches the specified {@code clazz} and {@code parameterTypes}
     */
    public static boolean hasConstructorSilent(Class<?> clazz, Object... args) {
        return getConstructorSilent(clazz, args) != null;
    }


    //--- invokeConstructor ----------------------------------------------------

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class.
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     * control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     * abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T invokeConstructor(Constructor<?> constructor)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return invokeConstructor(constructor, EMPTY_OBJECT_ARRAY);
    }

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class, with the specified initialization parameters.
     * @param arguments array of objects to be passed as arguments to the constructor call; values of primitive
     * types are wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link
     * java.lang.Float Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     * control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     * abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T invokeConstructor(Constructor<?> constructor, Object... arguments)
        throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (T) constructor.newInstance(arguments);
    }

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class, with the specified initialization parameters.
     * @param argument object to be passed as argument to the constructor call; values of primitive types are
     * wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link java.lang.Float
     * Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     *
     * @throws IllegalAccessException if this {@code Constructor} object is enforcing Java language access
     * control and the underlying constructor is inaccessible.
     * @throws InstantiationException if the class that declares the underlying constructor represents an
     * abstract class.
     * @throws InvocationTargetException if the underlying constructor throws an exception.
     */
    public static <T> T invokeConstructor(Constructor<?> constructor, Object argument)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return invokeConstructor(constructor, new Object[] {argument});
    }

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class.
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T invokeConstructorSilent(Constructor<?> constructor) {
        return invokeConstructorSilent(constructor, EMPTY_OBJECT_ARRAY);
    }

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class, with the specified initialization parameters.
     * @param arguments array of objects to be passed as arguments to the constructor call; values of primitive
     * types are wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link
     * java.lang.Float Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T invokeConstructorSilent(Constructor<?> constructor, Object... arguments) {
        try {
            return (T) constructor.newInstance(arguments);
        } catch(Exception ignored) {
            // Exception not thrown
        }
        return null;
    }

    /**
     * @param constructor {@code Constructor} object to create and initialize a new instance of the
     * constructor's declaring class, with the specified initialization parameters.
     * @param argument object to be passed as argument to the constructor call; values of primitive types are
     * wrapped in a wrapper object of the appropriate type (e.g. a {@code float} in a {@link java.lang.Float
     * Float})
     * @param <T> Class type
     *
     * @return a new object created by calling the constructor this object represents
     */
    public static <T> T invokeConstructorSilent(Constructor<?> constructor, Object argument) {
        return invokeConstructorSilent(constructor, new Object[] {argument});
    }
}
