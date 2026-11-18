public class StudyRoom {

    private String name;
    private String reservedBy = null;

    public StudyRoom(String name) {
        this.name = name;
    }

    public synchronized boolean reserve(
            String user) {

        if (reservedBy != null) {
            return false;
        }

        reservedBy = user;
        return true;
    }

    public synchronized void release() {
        reservedBy = null;
    }

    public synchronized String
            getReservedBy() {

        return reservedBy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return("to String " + name);
    }

    public static void main(String[] args) {

        StudyRoom room =
            new StudyRoom(
                "Engineering Study Room"
            );

        System.out.println(
            "Reserve for Sam: "
            + room.reserve("Sam")
        );

        System.out.println(
            "Reserved by: "
            + room.getReservedBy()
        );

        room.release();

        System.out.println(
            "After release: "
            + room.getReservedBy()
        );
    }
}
