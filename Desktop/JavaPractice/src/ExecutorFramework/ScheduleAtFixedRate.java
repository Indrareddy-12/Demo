package ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRate {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(2);

    Runnable task=()-> {

        for (int i = 1; i <= 3; i++) {

            System.out.println("Task " + i + " Executing by " + Thread.currentThread().getName());


        }
    };

        scheduler.scheduleAtFixedRate(task,2,3, TimeUnit.SECONDS);

      scheduler.awaitTermination(40,TimeUnit.SECONDS);


    }


}
