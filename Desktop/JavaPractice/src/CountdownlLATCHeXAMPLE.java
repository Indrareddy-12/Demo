import java.util.concurrent.CountDownLatch;

public class CountdownlLATCHeXAMPLE {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        Thread t1=new Thread(new Mythread("Indra",latch));

        Thread t2=new Thread(new Mythread("Ram",latch));

        Thread t3=new Thread(new Mythread("Bheem",latch));

        t1.start();
        t2.start();
        t3.start();
        latch.await();
        System.out.println("Completed");



    }


}
    class Mythread implements Runnable{
     String name;
     CountDownLatch latch;

        public Mythread(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {
            try{
                System.out.println(name+"   Started Work");
                Thread.sleep(1500);
                System.out.println(name+"   is Completed its Work");
                Thread.sleep(1500);
              latch.countDown();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }


