public class Jeep extends RentalVehicle {

    public static void main(String[] args) {}
    public Jeep(String name, double rate) {
        super(name, rate);
    }
   
    @Override
    public String getActivity() {
        return "Off Roading Activity";
    }
}
