public class Equipment extends Resource {
    private String category;

    public Equipment(String id, String name, String category) {
        super(id, name);
        this.category = category;
    }

    @Override
    public String getType() {
        return "Equipment";
    }

    public String getCategory() {
        return category;
    }
}
