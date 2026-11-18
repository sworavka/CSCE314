

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

        //Display room inventory
        for(StudyRoom room: catalog.getAllRooms()){
            System.out.println("Room ID: " + room.getId() + ", Name: " + room.getName() + ", Capacity: " + room.getCapacity() + ", Features: " + room.getFeatures());
        }

        String roomID;
        String user1;
        String user2;
        if(args.length >= 1){
            roomID = args[0];
            if(args.length >= 2){
                user1 = args[1];
                if(args.length >= 3){
                    user2 = args[2];
                }else{
                    user2 = "user2";
                }
            }else{
                user1 = "user1";
                user2 = "user2";
            }
        }else{
            roomID = "Zach101";
            user1 = "user1";
            user2 = "user2";
        }

        catalog.addRoom(new StudyRoom(roomID, "name", 0));
    
        StudyRoom myRoom = catalog.getRoom(roomID);
        
        
        ReservationTask task1 = new ReservationTask(myRoom, user1);
        ReservationTask task2 = new ReservationTask(myRoom, user2);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();

        }catch (InterruptedException e){//we shouldnt ever have to execute this
            System.out.println(e.getMessage());
        }
        System.out.println("was reservation 1 successful? "+ task1.wasSuccessful());
        System.out.println("was reservation 2 successful? "+ task2.wasSuccessful());
    
    
    
    }
}
