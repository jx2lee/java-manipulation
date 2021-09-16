package com.jx2lee.thejava.reflection;

public class ClassInfo {
    private static String b = "test1";
    private static final String c = "test2";

    private String a;
    public String d = "d";
    protected String e = "e";

    public ClassInfo() {
    }

    public ClassInfo(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("ClassInfo.testFunction");
    }

    public void g() {
        System.out.println("ClassInfo.g");
    }

    public int h() {
        return 99;
    }
}
