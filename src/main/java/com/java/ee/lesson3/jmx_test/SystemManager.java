package com.java.ee.lesson3.jmx_test;

public class SystemManager implements SystemManagerMBean {

    private int threadCount;

    @Override
    public int getThreadCount() {
        System.out.println("get -> thread count " + threadCount);
        return threadCount;
    }

    @Override
    public void setThreadCount(int threadCount) {
        System.out.println("set -> thread count " + threadCount);
        this.threadCount = threadCount;
    }

    @Override
    public void doSomething() {
        System.out.println("ghjhjgjh");
    }
}
