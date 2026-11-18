import java.util.ArrayList;

public class Main {
    public static <T extends RentalVehicle> void showVehicle(T vehicle){
       System.out.println(vehicle.getDescription()); 
    }
    public static void main (String[] args) {
        Jeep rangler = new Jeep("Jeep", 20);
        try{
            rangler.rent("Sam");
        } catch(IllegalStateException e) {
            System.out.println("A vehicle can only be rented by one customer at a time.");
        }
        ATV polaris = new ATV("ATV", 30);
        JetSki zoom = new JetSki("JetSki", 40);
        ArrayList<RentalVehicle> vehicles = new ArrayList<>();
        vehicles.add(rangler);
        vehicles.add(polaris);
        vehicles.add(zoom);
        for(RentalVehicle vehicle:vehicles){
            showVehicle(vehicle);
        }
    }
}