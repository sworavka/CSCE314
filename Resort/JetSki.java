public class JetSki extends RentalVehicle {

    public static void main(String[] args) {}
    public JetSki(String name, double rate) {
        super(name, rate);
    }

    @Override
    public String getActivity() {
        return "Water Activity";
    }

}
