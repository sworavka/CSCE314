import java.util.concurrent.Callable;

public class ReservationTaskDemo
        implements Callable<String> {

    private StudyRoom room;
    private String user;

    public ReservationTaskDemo(
            StudyRoom room,
            String user) {

        this.room = room;
        this.user = user;
    }

    @Override
    public String call() {

        boolean success =
            room.reserve(user);

        if (success) {
            return (
                user
                + " reserved "
                + room.getName()
            );
        } else {
            return (
                user
                + " could not reserve "
                + room.getName()
            );
        }
    }
}
