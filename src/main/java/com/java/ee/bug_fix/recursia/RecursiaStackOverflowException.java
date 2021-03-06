package com.java.ee.bug_fix.recursia;

public class RecursiaStackOverflowException {
    public static void main(String[] args) {
        int input;
        System.out.println("Please enter an integer greater than one: ");

        sumReverse(5);
    }

    public static void sumReverse(int n) {
        int x = n;

        if (x == 0) {
            System.out.print(x);
            return;
        }
        else if (x > 0) {
            System.out.print(x + " ");
        }
        x--;
        sumReverse(x);
    }

//input: 5
//result: 4 3 2 1 0
}
