package com.jx2lee.thejava.annotation;

import com.jx2lee.thejava.reflection.ClassInfo;
import com.jx2lee.thejava.reflection.MyClassInfo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(ClassInfo.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(MyClassInfo.class.getAnnotations()).forEach(System.out::println);
        System.out.println("ClassInfo.class.getAnnotation(TestAnnotation.class).name() = " + ClassInfo.class.getAnnotation(TestAnnotation.class).name());
        Arrays.stream(ClassInfo.class.getDeclaredAnnotations()).forEach(f1 -> Arrays.stream(ClassInfo.class.getAnnotations()).forEach(f2 -> {
          if (f2 instanceof TestAnnotation) {
              TestAnnotation testAnnotation = (TestAnnotation) f2;
              System.out.println("testAnnotation = " + testAnnotation.name());
          }
        }));
    }
}
