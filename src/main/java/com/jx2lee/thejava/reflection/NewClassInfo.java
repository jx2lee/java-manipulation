package com.jx2lee.thejava.reflection;

public class NewClassInfo {
    /// public static filed
    public static String publicField = "A";

    // private field
    private String privateField = "B";

    // default constructor
    public NewClassInfo() {
    }

    // constructor
    public NewClassInfo(String privateField) {
        this.privateField = privateField;
    }

    // public void method
    public void publicVoidMethod() {
        System.out.println("NewClassInfo.publicVoidMethod");
    }

    // private return method
    private int privateReturnIntMethod(int left, int right) {
        return left + right;
    }

    public String getPrivateField() {
        return privateField;
    }

    public static String getPublicField() {
        return publicField;
    }
}
