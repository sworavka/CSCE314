public class StorageBox<T> {
    private T item;
    public void store(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
