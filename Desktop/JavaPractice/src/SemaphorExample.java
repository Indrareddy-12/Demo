import java.util.concurrent.Semaphore;

class ParkingLotWorker implements Runnable {
    private Semaphore semaphore;
    private String carName;

    ParkingLotWorker(Semaphore semaphore, String carName) {
        this.semaphore = semaphore;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            System.out.println(carName + " is trying to enter the parking lot...");
            semaphore.acquire();
            System.out.println(carName + " parked.");
            Thread.sleep(2000);
//            System.out.println(carName + " is leaving the parking lot.");
//            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Thread car1 = new Thread(new ParkingLotWorker(semaphore, "Car-1"));
        Thread car2 = new Thread(new ParkingLotWorker(semaphore, "Car-2"));
        Thread car3 = new Thread(new ParkingLotWorker(semaphore, "Car-3"));
        Thread car4 = new Thread(new ParkingLotWorker(semaphore, "Car-4"));
        Thread car5 = new Thread(new ParkingLotWorker(semaphore, "Car-5"));

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
    }
}
