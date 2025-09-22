package ExecutorFramework;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduleThreads {

    public static void main(String[] args) {

        ScheduledExecutorService schedular= Executors.newScheduledThreadPool(3);

        for(int i=1;i<=5;i++) {
            int id = i;

            Runnable task = () -> {

                System.out.println("Task " + id + " Executing by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            schedular.schedule(task, 2, TimeUnit.SECONDS);

        }
        schedular.shutdown();

    }

}
