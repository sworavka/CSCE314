public class Equipment {
    private String name;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String use() {
        return "Using equipment";
    }
}
