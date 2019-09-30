package com.akpanda.execframework.runnable;

public class SingleTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Single task running");
    }
}
