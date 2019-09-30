package com.akpanda.execframework.runner;

import com.akpanda.execframework.runnable.CallableTask;
import com.akpanda.execframework.runnable.SingleTask;

import java.util.concurrent.*;

public class RunnableClient {
    public static void main(String[] args) {
        Runnable runnable = new SingleTask();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(runnable);
        //executorService.shutdown();

        Callable callable = new CallableTask();
        Future<String> futureString = executorService.submit(callable);
        boolean listen = true;
        while(listen){
            if(futureString.isDone()){
                String result;
                try{
                    result = futureString.get();
                    listen = false;
                    System.out.println(result);
                }catch (InterruptedException | ExecutionException e){
                    e.printStackTrace();
                }
            }
        }
        executorService.shutdown();
    }
}
