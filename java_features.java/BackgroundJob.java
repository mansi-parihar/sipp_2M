public class BackgroundJob {
    public static void main(String[] args) {
        Runnable job1 = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("✅ Job 1 completed in background.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable job2 = () -> {
            try {
                Thread.sleep(1500);
                System.out.println("✅ Job 2 completed in background.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job2);

        t1.start();
        t2.start();

        System.out.println("👉 Main thread is free to do other work...");
    }
}
