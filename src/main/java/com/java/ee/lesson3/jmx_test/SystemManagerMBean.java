package com.java.ee.lesson3.jmx_test;

public interface SystemManagerMBean {

    int getThreadCount();

    void setThreadCount(int threadCount);

    void doSomething();
}
