public class ATV extends RentalVehicle {

    public static void main(String[] args) {}
    public ATV(String name, double rate) {
        super(name, rate);
    }

    @Override
    public String getActivity() {
        return "Mud Activity";
    }
}
