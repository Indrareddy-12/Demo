package ExecutorFramework;

import java.util.concurrent.*;

public class CallableTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor= Executors.newSingleThreadExecutor();

        Callable<String> task=()->{

            System.out.println("Thread is Started");

            Thread.sleep(1200);

            return "This is Thread Output";
        };

        Future<String> result= executor.submit(task);
        System.out.println(result.get());


    }


}
