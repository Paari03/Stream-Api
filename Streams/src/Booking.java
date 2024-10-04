import java.util.concurrent.atomic.AtomicInteger;

class Booking extends Thread
{
    private static AtomicInteger seat = new AtomicInteger(2);

    public void bookSeat(String name) {
        if(seat.get() > 0) {
            seat.decrementAndGet();
            System.out.println(name + " successfully booked a seat!");
        }
        else {
            System.out.println(name + " failed to book a seat. No seats available.");

        }
    }

    @Override
    public void run()
    {
        bookSeat(Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        Booking booking = new Booking();

        Thread person1 = new Thread(booking);
        Thread person2 = new Thread(booking);
        Thread person3 = new Thread(booking);

        person1.start();
        person3.start();
        person2.start();

    }
}
