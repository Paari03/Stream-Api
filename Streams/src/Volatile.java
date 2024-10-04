public class Volatile extends Thread {
    private volatile  boolean isRunning = true;
    static int  i = 0;

    public void run() {
        while (isRunning) {
            i = i + 1;
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }

    public void stopRunning() {
        isRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile volatile1 = new Volatile();
        Volatile volatile2 = new Volatile();

        Thread thread1 = new Thread(volatile1, "Thread 1");
        Thread thread2 = new Thread(volatile2, "Thread 2");

        thread1.start();
        thread2.start();

        Thread.sleep(1);

        System.out.println("Stopping the thread 1...");
        volatile1.stopRunning();

        System.out.println("Stopping the thread 2...");
        volatile2.stopRunning();
    }
}
