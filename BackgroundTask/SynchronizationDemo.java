import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizationDemo {

    public static void main(String[] args)
            throws InterruptedException,
            ExecutionException {

        StudyRoom room =
            new StudyRoom(
                "Engineering Study Room"
            );

        ReservationTaskDemo task1 =
            new ReservationTaskDemo(
                room,
                "Sam"
            );

        ReservationTaskDemo task2 =
            new ReservationTaskDemo(
                room,
                "Maria"
            );

        // Thread t1 =
        //     new Thread(task1);

        // Thread t2 =
        //     new Thread(task2);

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        ExecutorService pool =
            Executors.newFixedThreadPool(2);

        Future<String> result1 =
            pool.submit(task1);

        Future<String> result2 =
            pool.submit(task2);

        System.out.println(
            result1.get()
        );

        System.out.println(
            result2.get()
        );

        pool.shutdown();

        System.out.println(
            "Final reservation: "
            + room.getReservedBy()
        );

        System.out.println(room);
    }
}
