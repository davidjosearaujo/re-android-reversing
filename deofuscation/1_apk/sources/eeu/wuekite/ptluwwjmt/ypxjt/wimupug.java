package eeu.wuekite.ptluwwjmt.ypxjt;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* compiled from: Reflect.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class wimupug {
    public static Field wvtnrjvsu(Object instance, String name) throws NoSuchFieldException {
        for (Class clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(name);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("Field " + name + " not found in " + instance.getClass());
    }

    public static Method jjseddonov(Object instance, String name, Class... parameterTypes) throws NoSuchMethodException {
        for (Class clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Method method = clazz.getDeclaredMethod(name, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException("Method " + name + " with parameters " + Arrays.asList(parameterTypes) + " not found in " + instance.getClass());
    }

    public static Object mjokkyjqmenm(Class<?> clazz, Object obj, Object[] args, String methodName, Class<?>... parameterTypes) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(obj, args);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object yixvfreyetriy(Class<?> clazz, Object obj, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object yixvfreyetriy(String className, Object obj, String fieldName) {
        try {
            Class<?> clazz = Class.forName(className);
            return yixvfreyetriy(clazz, obj, fieldName);
        } catch (ClassNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean yiegtikwkhqwt(Class<?> clazz, Object obj, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean yiegtikwkhqwt(String className, Object obj, String fieldName, Object value) {
        try {
            Class<?> clazz = Class.forName(className);
            yiegtikwkhqwt(clazz, obj, fieldName, value);
            return true;
        } catch (ClassNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
