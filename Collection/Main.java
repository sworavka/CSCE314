import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        RoomCatalog catalog = new RoomCatalog();
        catalog.addRoom(new StudyRoom("ZACH101","Collaboration Room",6));
        catalog.addRoom(new StudyRoom("ZACH102","Quiet Room",4));
        catalog.addRoom(new StudyRoom("ZACH103","Conference Room",8));

        catalog.getRoom("ZACH101").addFeature("Whiteboard");
        catalog.getRoom("ZACH102").addFeature("Quiet");
        catalog.getRoom("ZACH103").addFeature("Monitor");
        catalog.getRoom("ZACH103").addFeature("Accessible");

        System.out.println();
        StudyRoom myRoom = catalog.getRoom("ZACH101");
        
        ReservationTask task1 = new ReservationTask(myRoom, "Sam");
        ReservationTask task2 = new ReservationTask(myRoom, "Maria");
        ReservationTask task3 = new ReservationTask(catalog.getRoom("ZACH102"), "Taylor");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ArrayList<Future<String>> futures = new ArrayList<>();
        futures.add(executor.submit(task1));
        futures.add(executor.submit(task2));
        futures.add(executor.submit(task3));
        executor.shutdown();

        for(Future<String> future : futures){
            try{
                String result = future.get();
                System.out.println(result);
            } catch (ExecutionException e) {
                System.out.println("Unable to retrieve results.");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        if(catalog.getRoom("ZACH101").isReserved()){
            System.out.println("ZACH101 is reserved by " + catalog.getRoom("ZACH101").getReservedBy());
        }
        if(catalog.getRoom("ZACH102").isReserved()){
            System.out.println("ZACH102 is reserved by " + catalog.getRoom("ZACH102").getReservedBy());
        }
    }
}
