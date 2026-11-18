public class Vehicle extends Resource{
    private int seats;

    public Vehicle(String id, String name, int seats){
        super(id, name);
        this.seats = seats;
    }

    public int getSeats(){
        return seats;
    }
    @Override
    public String getType(){
        return "Vehicle";
    }

    
}