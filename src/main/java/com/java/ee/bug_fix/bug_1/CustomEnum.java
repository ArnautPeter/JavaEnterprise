package com.java.ee.bug_fix.bug_1;

public enum CustomEnum {
    //PLEASE uncomment
    ACTION_ONE(0),
    ACTION_TWO(1),
    ECTION_THREE(2);

    private int i;

    CustomEnum(int i) {
        this.i = i;
    }
}
