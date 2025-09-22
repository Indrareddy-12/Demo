package ExecutorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService executor= Executors.newFixedThreadPool(2);

        for(int i=1;i<=5;i++) {
            int taskNumber = i;
            Runnable task = (() -> {
                System.out.println("Task " + taskNumber + "  is Executing by  "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            });



            executor.execute(task);
        }



    }



}
