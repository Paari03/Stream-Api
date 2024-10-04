import java.util.HashMap;

public class HashMapExample {

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
            for (String key : map.keySet()) {
                System.out.println("Reading: " + key + " = " + map.get(key));

            }
        });

        writerThread.start();
        readerThread.start();

        readerThread.join();

        System.out.println("Final Map: " + map);
    }
}
