package com.jx2lee.thejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainPartTwo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> NewClassInfoClass = Class.forName("com.jx2lee.thejava.reflection.NewClassInfo");
        Constructor<?> constructor = NewClassInfoClass.getConstructor(String.class);
        NewClassInfo newClassInfo = (NewClassInfo) constructor.newInstance("test");

        System.out.println("newClassInfo = " + newClassInfo);
        System.out.println("newClassInfo.getPrivateField() = " + newClassInfo.getPrivateField());

        System.out.println();
        System.out.println("newClassInfo = " + newClassInfo);
        System.out.println("newClassInfo. = " + newClassInfo.getPrivateField());
        System.out.println();
        System.out.println("==================");
        System.out.println();

        // public field 호출 및 field value 변경
        Field publicField = NewClassInfo.class.getField("publicField");
        System.out.println("publicField.get(null) = " + publicField.get(null));

        publicField.set(null, "A -> B 로 변경");
        System.out.println("publicField.get(null) = " + publicField.get(null));
        System.out.println();
        System.out.println("==================");
        System.out.println();

        // private field 호출 및 field value 변경
        Field privateField = NewClassInfo.class.getDeclaredField("privateField");
        privateField.setAccessible(true);

        System.out.println("privateField.get(newClassInfo) = " + privateField.get(newClassInfo));

        privateField.set(newClassInfo, "test 에서 test2로 변경");
        System.out.println("privateField.get(newClassInfo) = " + privateField.get(newClassInfo));

        System.out.println();
        System.out.println("==================");
        System.out.println();

        // public & private 함수 호출
        /// public method 호출
        Method publicMethod = NewClassInfo.class.getDeclaredMethod("publicVoidMethod");
        publicMethod.invoke(newClassInfo);

        // private method 호출
        Method privateReturnMethod = NewClassInfo.class.getDeclaredMethod("privateReturnIntMethod", int.class, int.class);
        privateReturnMethod.setAccessible(true);
        System.out.println("privateReturnMethod.invoke(newClassInfo, 1,2) = " + privateReturnMethod.invoke(newClassInfo, 1,2));
    }
}
