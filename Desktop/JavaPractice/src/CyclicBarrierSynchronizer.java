import java.util.concurrent.CyclicBarrier;

 class CyclicBarrierDemo {
    public static void main(String[] args) {
        // Barrier for 3 threads, with an action once all arrive
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("All threads reached barrier. Proceeding together!"));

        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }
}

class Worker implements Runnable {
    private CyclicBarrier barrier;
    private int id;

    Worker(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("Thread " + id + " doing some work...");
            Thread.sleep(1000 * id); // simulate different work times
            System.out.println("Thread " + id + " waiting at barrier");
            barrier.await(); // wait until all threads arrive
            System.out.println("Thread " + id + " passed the barrier");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
