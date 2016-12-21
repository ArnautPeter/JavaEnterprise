package com.java.ee.homework11.manager;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class UserListener implements AsyncListener {

    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("--> onComplete");
    }

    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("--> onTimeout");
    }

    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("--> onError");
    }

    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("--> onStartAsync");
    }
}
