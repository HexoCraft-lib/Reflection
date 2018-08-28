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

import org.inventivetalent.reflection.resolver.MethodResolver;
import org.inventivetalent.reflection.resolver.ResolverQuery;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtil {

    private static final Class<?>[] EMPTY_CLASS_ARRAY  = new Class<?>[0];
    private static final Object[]   EMPTY_OBJECT_ARRAY = new Object[0];

    private MethodUtil() {
        throw new IllegalAccessError("This is a private constructor Use static functions instead.");
    }


    //--- getMethod ------------------------------------------------------------

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     * @param parameterTypes the list of parameters
     *
     * @return the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     *
     * @throws NoSuchMethodException If {@code name} not exist in {@code clazz}
     */
    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes)
        throws NoSuchMethodException {
        return new MethodResolver(clazz).resolve(new ResolverQuery(name, parameterTypes));
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     * @param parameterTypes the list of parameters
     *
     * @return the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     */
    public static Method getMethodSilent(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return new MethodResolver(clazz).resolve(new ResolverQuery(name, parameterTypes));
        } catch(NoSuchMethodException ignored) {
            // Exception not thrown
        }
        return null;
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     *
     * @return the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     *
     * @throws NoSuchMethodException If {@code name} not exist in {@code clazz}
     */
    public static Method getMethod(Class<?> clazz, String name) throws NoSuchMethodException {
        return new MethodResolver(clazz).resolve(new ResolverQuery(name, EMPTY_CLASS_ARRAY));
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     *
     * @return the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     */
    public static Method getMethodSilent(Class<?> clazz, String name) {
        try {
            return new MethodResolver(clazz).resolve(new ResolverQuery(name, EMPTY_CLASS_ARRAY));
        } catch(NoSuchMethodException ignored) {
            // Exception not thrown
        }
        return null;
    }


    //--- hasMethod ------------------------------------------------------------

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     * @param parameterTypes the list of parameters
     *
     * @return true if the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     *
     * @throws NoSuchMethodException If {@code name} not exist in {@code clazz}
     */
    public static boolean hasMethod(Class<?> clazz, String name, Class<?>... parameterTypes)
        throws NoSuchMethodException {
        getMethod(clazz, name, parameterTypes);
        return true;
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     * @param parameterTypes the list of parameters
     *
     * @return true if the {@code Method} object that matches the specified {@code clazz} and {@code name} and {@code
     * parameterTypes}
     */
    public static boolean hasMethodSilent(Class<?> clazz, String name, Class<?>... parameterTypes) {
        return getMethodSilent(clazz, name, parameterTypes) != null;
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     *
     * @return true if the {@code Method} object that matches the specified {@code clazz} and {@code name}
     *
     * @throws NoSuchMethodException If {@code name} not exist in {@code clazz}
     */
    public static boolean hasMethod(Class<?> clazz, String name) throws NoSuchMethodException {
        return hasMethod(clazz, name, EMPTY_CLASS_ARRAY);
    }

    /**
     * @param clazz Class that should contain the method
     * @param name the name of the method
     *
     * @return true if the {@code Method} object that matches the specified {@code clazz} and {@code name}
     */
    public static boolean hasMethodSilent(Class<?> clazz, String name) {
        return getMethodSilent(clazz, name) != null;
    }


    //--- invokeMethod ---------------------------------------------------------

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param arguments the arguments used for the method call
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     *
     * @throws InvocationTargetException if the underlying method throws an exception.
     * @throws IllegalAccessException if this {@code Method} object
     * is enforcing Java language access control and the underlying
     * method is inaccessible.
     */
    public static <T> T invokeMethod(Method method, Object target, Object... arguments)
        throws InvocationTargetException, IllegalAccessException {
        return (T) method.invoke(target, arguments);
    }

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param arguments the arguments used for the method call
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     */
    public static <T> T invokeMethodSilent(Method method, Object target, Object... arguments) {
        try {
            return (T) method.invoke(target, arguments);
        } catch(IllegalAccessException | InvocationTargetException ignored) {
            // Exception not thrown
        }
        return null;
    }

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param argument the argument used for the method call
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     *
     * @throws InvocationTargetException if the underlying method throws an exception.
     * @throws IllegalAccessException if this {@code Method} object
     * is enforcing Java language access control and the underlying
     * method is inaccessible.
     */
    public static <T> T invokeMethod(Method method, Object target, Object argument)
        throws InvocationTargetException, IllegalAccessException {
        return invokeMethod(method, target, new Object[] {argument});
    }

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param argument the argument used for the method call
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     */
    public static <T> T invokeMethodSilent(Method method, Object target, Object argument) {
        return invokeMethodSilent(method, target, new Object[] {argument});
    }

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     *
     * @throws InvocationTargetException if the underlying method throws an exception.
     * @throws IllegalAccessException if this {@code Method} object
     * is enforcing Java language access control and the underlying
     * method is inaccessible.
     * the corresponding formal parameter type by a method invocation conversion.
     */
    public static <T> T invokeMethod(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        return (T) invokeMethod(method, target, EMPTY_OBJECT_ARRAY);
    }

    /**
     * @param method the method to invoke
     * @param target the object the underlying method is invoked from
     * @param <T> class type
     *
     * @return the result of dispatching the method represented by this object on {@code target} with parameters {@code
     * arguments}
     */
    public static <T> T invokeMethodSilent(Method method, Object target) {
        return (T) invokeMethodSilent(method, target, EMPTY_OBJECT_ARRAY);
    }
}
