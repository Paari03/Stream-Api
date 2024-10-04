import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentExample {

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> map = new HashMap<>();
        Thread writerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Adding: " + i);
                map.put("key" + i, i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println("Reading: key" + i + " = " + map.get("key" + i)); // Read from the map
            }
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();

        System.out.println("Final Map: " + map);
    }
}
