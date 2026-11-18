public class ReservationTask implements Runnable {
    private StudyRoom room;
    private String user;
    private boolean reservation_successful;


    public ReservationTask( StudyRoom room, String user) {
        this.room = room;
        this.user = user;

    }
    @Override 
    public void run(){
        if(room.isReserved()){
            reservation_successful = true;
        }else{
            room.reserve(user);
            reservation_successful = false;
        }
        
    }
    public boolean wasSuccessful(){
        return reservation_successful;
    }
    public String getUser(){
        return user;
    }
}
