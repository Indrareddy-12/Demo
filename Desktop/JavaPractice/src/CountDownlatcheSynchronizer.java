import java.util.concurrent.CountDownLatch;

public class CountDownlatcheSynchronizer {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new PreRequirements("FuelCheck", latch)).start();
        new Thread(new PreRequirements("Condition Check", latch)).start();
        new Thread(new PreRequirements("Demo start", latch)).start();


        latch.await();
        System.out.println("Completed Ready to Go");

    }

}
class PreRequirements implements Runnable {

    String taskName;
    private CountDownLatch latch;

    public  PreRequirements(String taskName, CountDownLatch latch) {
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(taskName + "    Started");
            latch.countDown();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
