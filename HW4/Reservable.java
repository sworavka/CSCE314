public interface Reservable {
    void reserve(String user) throws ResourceUnavailableException;
    void release();
    boolean isReserved();
    String getReservedBy();
}
