import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentreatLockExample {
   static ReentrantLock lock=new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        ReentreatLockExample obj=new ReentreatLockExample()
;        for(int i=1;i<=5;i++)
        {
            Thread t1 = new Thread(new Work(i));
            t1.start();
            t1.join();
        }
    }
}
 class Work implements Runnable{
  int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Work "+id+" Is Trying to acquire Lock");
        ReentreatLockExample.lock.lock();
        try {
            Thread.sleep(1500);
            System.out.println("Worker "+id+" is Accquired Lock");
            System.out.println("Others Waiting to Acquire");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
       ReentreatLockExample.lock.unlock();
        }


    }
}
