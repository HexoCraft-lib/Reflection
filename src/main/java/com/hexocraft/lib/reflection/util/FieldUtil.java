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


import org.inventivetalent.reflection.resolver.FieldResolver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class FieldUtil {

    private FieldUtil() {
        throw new IllegalAccessError("This is a private constructor Use static functions instead.");
    }


    //--- getField -------------------------------------------------------------

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     *
     * @return the {@code Field} that matches the specified {@code clazz} and {@code name}
     *
     * @throws NoSuchFieldException If not exist in {@code clazz}
     */
    public static Field getField(Class<?> clazz, String name) throws NoSuchFieldException {
        return new FieldResolver(clazz).resolve(name);
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     *
     * @return the {@code Field} that matches the specified {@code clazz} and {@code name}
     */
    public static Field getFieldSilent(Class<?> clazz, String name) {
        return new FieldResolver(clazz).resolveSilent(name);
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code clazz} and {@code name} and {@code from}
     *
     * @throws NoSuchFieldException If not exist in {@code clazz}
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static Object getField(Class<?> clazz, String name, Object from) throws NoSuchFieldException, IllegalAccessException {
        return getField(clazz, name).get(from);
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code clazz} and {@code name} and {@code from}
     */
    public static Object getFieldSilent(Class<?> clazz, String name, Object from) {
        try {
            return getField(clazz, name).get(from);
        }
        catch (IllegalAccessException | NoSuchFieldException ignored) {
            // Exception not thrown
        }
        return null;
    }

    /**
     * @param field field to get
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code field} and {@code from}
     *
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static Object getField(Field field, Object from) throws IllegalAccessException {
        return field.get(from);
    }

    /**
     * @param field field to get
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code field} and {@code from}
     */
    public static Object getFieldSilent(Field field, Object from) {
        try {
            return field.get(from);
        }
        catch (IllegalAccessException ignored) {
            // Exception not thrown
        }
        return null;
    }

    /**
     * @param <T> Class to cast
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code name} and {@code from}
     *
     * @throws NoSuchFieldException If not exist in {@code from}
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static <T> T getField(String name, Object from) throws NoSuchFieldException, IllegalAccessException {
        return (T) getField(from.getClass(), name).get(from);
    }

    /**
     * @param <T> Class to cast
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return the {@code Object} object that matches the specified {@code name} and {@code from}
     */
    public static <T> T getFieldSilent(String name, Object from) {
        try {
            return (T) getField(from.getClass(), name).get(from);
        }
        catch (IllegalAccessException | NoSuchFieldException ignored) {
            // Exception not thrown
        }
        return null;
    }


    //--- hasField -------------------------------------------------------------

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     *
     * @return true if the {@code Field} that matches the specified {@code clazz} and {@code name}
     *
     * @throws NoSuchFieldException If not exist in {@code clazz}
     */
    public static boolean hasField(Class<?> clazz, String name) throws NoSuchFieldException {
        getField(clazz, name);
        return true;
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     *
     * @return true if the {@code Field} that matches the specified {@code clazz} and {@code name}
     */
    public static boolean hasFieldSilent(Class<?> clazz, String name) {
        return getFieldSilent(clazz, name) != null;
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code clazz} and {@code name} and {@code from}
     *
     * @throws NoSuchFieldException If not exist in {@code clazz}
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static boolean hasField(Class<?> clazz, String name, Object from) throws NoSuchFieldException, IllegalAccessException {
        getField(clazz, name, from);
        return true;
    }

    /**
     * @param clazz Class that should contain the field
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code clazz} and {@code name} and {@code from}
     */
    public static boolean hasFieldSilent(Class<?> clazz, String name, Object from) {
        return getFieldSilent(clazz, name, from) != null;
    }

    /**
     * @param field field to get
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code field} and {@code from}
     *
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static boolean hasField(Field field, Object from) throws IllegalAccessException {
        getField(field, from);
        return true;
    }

    /**
     * @param field field to get
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code field} and {@code from}
     */
    public static boolean hasFieldSilent(Field field, Object from) {
        return getFieldSilent(field, from) != null;
    }

    /**
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code name} and {@code from}
     *
     * @throws NoSuchFieldException If not exist in {@code from}
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is inaccessible.
     */
    public static boolean hasField(String name, Object from) throws NoSuchFieldException, IllegalAccessException {
        getField(name, from);
        return true;
    }

    /**
     * @param name the name of the field
     * @param from The object to get the field from
     *
     * @return true if the {@code Object} object that matches the specified {@code name} and {@code from}
     */
    public static boolean hasFieldSilent(String name, Object from) {
        return getFieldSilent(name, from) != null;
    }


    //--- setField -------------------------------------------------------------

    /**
     * @param field field to set
     * @param object the object whose field should be modified
     * @param value the new value for the field of {@code object}
     *
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and
     *         the underlying field is either inaccessible or final.
     */
    public static void setField(Field field, Object object, Object value) throws IllegalAccessException {
        field.set(object, value);
    }


    //--- transferFields -------------------------------------------------------

    public static void transferField(Class<?> clazz, Object from, Object to, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = getField(clazz, name);
        Object value = getField(field, from);
        setField(field, to, value);
    }

    public static void transferFields(Class<?> clazz, Object from, Object to, String... fieldNames) throws NoSuchFieldException, IllegalAccessException {
        List<String> aFieldNames = new ArrayList<>();
        Collections.addAll(aFieldNames, fieldNames);
        transferFields(clazz, from, to, aFieldNames);
    }

    public static void transferFields(Class<?> clazz, Object from, Object to, List<String> fieldNames) throws NoSuchFieldException, IllegalAccessException {
        if (fieldNames == null) {
            fieldNames = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                fieldNames.add(field.getName());
            }
        }

        for (String fieldName : fieldNames) {
            transferField(clazz, from, to, fieldName);
        }
    }

    public static void transferFields(Class<?> clazz, Object from, Object to) throws NoSuchFieldException, IllegalAccessException {
        transferFields(clazz, from, to, (List<String>) null);
    }
}
