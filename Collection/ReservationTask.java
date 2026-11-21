import java.util.concurrent.Callable;

public class ReservationTask implements Callable<String>{
    private StudyRoom room;
    private String user;
    private boolean reservation_successful;


    public ReservationTask( StudyRoom room, String user) {
        this.room = room;
        this.user = user;

    }
    @Override 
    public String call(){
        reservation_successful = room.reserve(user);
        if(reservation_successful){
            return user + " reserved " + room.getId();
        }else{
            return user + " could not reserve " + room.getId();
        }
        
    }
    public boolean wasSuccessful(){
        return reservation_successful;
    }
    public String getUser(){
        return user;
    }
}
