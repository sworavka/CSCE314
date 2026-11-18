public class LibraryDemo {
    public static void main(String[] args) {
        StudyRoom room1 = new StudyRoom("SR101", "Quiet Room", 1);
        Equipment printer1 = new Equipment("E101", "Printer 3D", "Bambu");
        Vehicle vehicle1 = new Vehicle("V101", "Ranger", 6);
        room1.addFeature("Whiteboard");
        printer1.addFeature("0.2mm nozzle");
        vehicle1.addFeature("4WD");
        ResourceCatalog<Resource> catalog = new ResourceCatalog<>();
        try {
            catalog.add(room1);
            catalog.add(printer1);
            catalog.add(vehicle1);
        } catch (DuplicateResourceException e) {
            System.out.println(e.getMessage());
        }
        for (Resource resource : catalog.getAll()) {
            System.out.println(resource.getDescription());
            System.out.println("Type: " + resource.getType());
        }
        System.out.println(Resource.getResourceCount() + " resources in catalog.");
        String user1 = "Sam";
        if(args.length > 0) {
            user1 = args[0];
        }
        try {
            room1.reserve(user1);
        } catch (ResourceUnavailableException e) {
            System.out.println(e.getMessage());
        }
        try {
            room1.reserve("Alex");
        } catch (ResourceUnavailableException e) {
            System.out.println(e.getMessage());
        }
        room1.release();
        try{
        catalog.add(new StudyRoom("SR101", "Quiet Room", 1));
        } catch (DuplicateResourceException e) {
            System.out.println(e.getMessage());
        }
        ReservationTask task1 = new ReservationTask(room1, "Sam");
        ReservationTask task2 = new ReservationTask(room1, "Alex");
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task1.getMessage());
        System.out.println(task2.getMessage());
        System.out.println(room1.getReservedBy() + " has reserved the room.");

    }
}
