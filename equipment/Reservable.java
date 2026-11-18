public interface Reservable {
    void reserve(String studentName);
    String getReservedBy();
    void returnItem();
}
