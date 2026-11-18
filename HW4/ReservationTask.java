public class ReservationTask implements Runnable {
    private Resource resource;
    private String user;
    private boolean reservationSuccessful;

    public ReservationTask(Resource resource, String user) {
        this.resource = resource;
        this.user = user;
    }

    @Override
    public void run() {
        try{
            resource.reserve(user);
        } catch (ResourceUnavailableException e) {
            reservationSuccessful = false;
            return;
        }
        reservationSuccessful = true;
    }

    public boolean wasSuccessful() {
        return reservationSuccessful;
    }

    public String getMessage() {
        if (reservationSuccessful) {
            return "Reservation successful for user: " + user;
        } else {
            return "Reservation failed for user: " + user + ". Resource is already reserved.";
        }
    }

    public String getUser() {
        return user;
    }
}
