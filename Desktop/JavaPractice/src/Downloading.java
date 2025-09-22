class SharedResource {
    int counter = 0;

    // Increment method
    public synchronized void increment() {
        counter++;
    }
    int getCounter(){
        return  counter;
    }
}

class ThreadLightWeightDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        // Create two threads that share the same resource
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();



        // Final value of counter
        System.out.println("Expected:  20");

        Thread.sleep(1000);

        String curr=Thread.currentThread().getName();

        System.out.println(curr);

       // System.out.println("Final Counter Value: " + resource.counter);
    }
}
//Thread-0 1
//Thread-0 3
//Thread-0 4
//Thread-0 5
//Thread-0 6
//Thread-0 7
//Thread-0 8
//Thread-0 9
//Thread-0 10
//Thread-1 2
//Thread-1 12
//Thread-0 11
//Thread-1 13
//Thread-1 14
//Thread-1 15
//Thread-1 16
//Thread-1 17
//Thread-1 18
//Thread-1 19
//Thread-1 20
