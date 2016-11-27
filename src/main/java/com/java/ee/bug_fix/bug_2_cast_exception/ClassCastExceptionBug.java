package com.java.ee.bug_fix.bug_2_cast_exception;

import java.io.IOException;

public class ClassCastExceptionBug {

    public static void main(String[] args) throws IOException {

        B b = new A();
        System.out.println(b.a);
    }
}

class A extends B {

    int a = 10;

    public void doSomethimg() {
        System.out.println("class A");
    }

}

class B {

    int a = 20;

    public void doSomethimg() {
        System.out.println("class B");
    }

}
