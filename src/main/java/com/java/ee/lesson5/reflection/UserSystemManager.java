package com.java.ee.lesson5.reflection;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

public class UserSystemManager {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User("xxx", 12);
        Class<? extends User> userClass = user.getClass();

        System.out.println("class name = " + userClass.getName());

        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            printModifiersById(constructor.getModifiers());
            System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
        }


        Field[] fields = userClass.getDeclaredFields(); //fields = userClass.getFields();
        for (Field field : fields) {
            printModifiersById(field.getModifiers());
            System.out.println(field.getName());
        }

        System.out.println(user);
        Field fieldName = userClass.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(user, "yyy");
        System.out.println(user);


        String test = "test";
        System.out.println(test.hashCode());
        test = test.concat("asf");
        System.out.println("str value = " + test + ",ch = " + test.hashCode());

        //case with reflection
        test = "test";
        System.out.println(test.hashCode());
        Field value = test.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(test, "test_xxx".toCharArray());
        System.out.println("str value = " + test + ",ch = " + test.hashCode());


        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object o = theUnsafe.get(null);
        if (o instanceof Unsafe) {
            Unsafe unsafe = (Unsafe) o;
            // unsafe.throwException(new IOException("!!!!!!!!!!!!!!!!"));

            Method[] methods = userClass.getMethods();
            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation an : annotations) {
                    UserAnnotation annotation = method.getAnnotation(UserAnnotation.class);
                    if (annotation == null) {
                        System.out.println(annotation.getClass());
                    }
                    System.out.println(an.annotationType().getName());
                }
            }
        }
    }

    private static void printModifiersById(int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public");
        }

        if (Modifier.isFinal(modifiers)) {
            System.out.println("final");
        }

        if (Modifier.isPrivate(modifiers)) {
            System.out.println("private");
        }
    }
}
