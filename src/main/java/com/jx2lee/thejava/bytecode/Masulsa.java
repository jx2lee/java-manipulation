package com.jx2lee.thejava.bytecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args) {
        try {
            new ByteBuddy().redefine(Moja.class)
                            .method(named("pullOut")).intercept(FixedValue.value("Tiger"))
                            .make().saveIn(new File("/Users/nhn/workspace/programming/java/the-java/out/production/classes"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());
    }
}
