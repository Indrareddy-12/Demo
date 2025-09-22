import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class cyclicBarrier implements Runnable{

    String name;
    CyclicBarrier barrier;

    public cyclicBarrier(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        System.out.println(name+" is Waiting in lobby");
        try{
            Thread.sleep(2000);
            System.out.println(name+"  Reached to Game Waiting for others");
            barrier.await();
            System.out.println(name+"  in Game");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }

    }
    class Working{

        public static void main(String[] args) {

            CyclicBarrier barrier=new CyclicBarrier(3,()->{
                System.out.println("Team is playing");
            });
            cyclicBarrier cb=new cyclicBarrier("rahul",barrier);
            cyclicBarrier cb1=new cyclicBarrier("Indra",barrier);
            cyclicBarrier cb2=new cyclicBarrier("shashi",barrier);

            Thread t1=new Thread(cb);
            Thread t2=new Thread(cb1);
            Thread t3=new Thread(cb2);
            t1.start();
            t2.start();
            t3.start();





        }


}
