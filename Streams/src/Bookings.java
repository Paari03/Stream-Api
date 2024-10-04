
class Bookings extends Thread
{
    private static int seats = 2;

    synchronized void bookSeat(String name) {
        if(seats > 0) {
            seats = seats-1;
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println(name + " successfully booked a seat!");
        }
        else {
            System.out.println(name + " failed to book a seat.");
        }
    }

    @Override
    public void run()
    {
        bookSeat(Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        Bookings booking = new Bookings();
        Thread person1 = new Thread(booking);
        Thread person2 = new Thread(booking);
        Thread person3 = new Thread(booking);

        person1.start();
        person2.start();
        person3.start();

    }
}
