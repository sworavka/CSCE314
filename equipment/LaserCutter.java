public class LaserCutter extends Equipment {

    public LaserCutter(String name) {
        super(name);
    }
    @Override
    public String use() {
        return "Cutting material with the laser.";
    }
}
