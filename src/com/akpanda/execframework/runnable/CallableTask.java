package com.akpanda.execframework.runnable;

import java.time.LocalDate;
import java.util.concurrent.Callable;

public class CallableTask implements Callable {

    @Override
    public Object call() throws Exception {
        return "Executing callable object at "+ LocalDate.now();
    }
}
