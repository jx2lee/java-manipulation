package com.jx2lee.thejava.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        // Check Class Info - type1
        Class<ClassInfo> classInfoClass = ClassInfo.class; // 클래스.class 로 접근
        ClassInfo classInfoInstance = new ClassInfo();
        System.out.println("<--------Type1-------->");

        printGetFields(classInfoClass.getFields(), classInfoClass.getDeclaredFields());
        printGetFieldDetails(classInfoInstance, classInfoClass.getDeclaredFields());
        printGetClassInfoDetails(classInfoClass, MyClassInfo.class);

        System.out.println("<--------Type1 End-------->");
        System.out.println();

        // Check Class Info - type2
        ClassInfo classInfo = new ClassInfo();
        Class<? extends ClassInfo> aClass = classInfo.getClass(); // 생성한 인스턴스의 getClass 로 접근
        System.out.println("<--------Type2-------->");

        printGetFields(aClass.getFields(), aClass.getDeclaredFields());
        printGetFieldDetails(classInfo, aClass.getDeclaredFields());
        printGetClassInfoDetails(aClass, MyClassInfo.class);

        System.out.println("<--------Type2 End-------->");
        System.out.println();

        // Check Class Info - type3
        Class<?> aClass1 = Class.forName("com.jx2lee.thejava.reflection.ClassInfo"); // pacake full path 로 접근

        System.out.println("<--------Type3-------->");

        printGetFields(aClass1.getFields(), aClass1.getDeclaredFields());
        printGetFieldDetails(classInfo, aClass1.getDeclaredFields());
        printGetClassInfoDetails(aClass1, MyClassInfo.class);

        System.out.println("<--------Type3 End-------->");

    }

    private static void printGetClassInfoDetails(Class<?> classInfoClass, Class<MyClassInfo> myClassInfoClass) {

        System.out.println("> Method 조회");
        Arrays.stream(classInfoClass.getMethods()).forEach(System.out::println);
        System.out.println();
        System.out.println("> 생성자 조회");
        Arrays.stream(classInfoClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println();
        System.out.println("> 상속받은 인터페이스 조회");
        Arrays.stream(myClassInfoClass.getInterfaces()).forEach(System.out::println);
        System.out.println();
    }

    private static void printGetFieldDetails(ClassInfo classInfoInstance, Field[] declaredFields) {

        System.out.println("> 전체조회 하는 데 값도 가져오기");
        Arrays.stream(declaredFields).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(classInfoInstance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println();

    }

    private static void printGetFields(Field[] fields, Field[] declaredFields) {
        System.out.println("> public 만 조회");
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println();
        System.out.println("> 전체조회");
        Arrays.stream(declaredFields).forEach(System.out::println);
        System.out.println();
    }
}
