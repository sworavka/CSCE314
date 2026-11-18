// package week11_friday;

public abstract class RentalVehicle implements Rentable{
    private String name;
    private double rate;
    private String rentedBy = null;
    private boolean is_rented;

    public RentalVehicle(String name, double rate){
        this.name = name;
        this.rate = rate;
        this.is_rented = false;
        // this.rentedBy = null;
    }

    public String getName(){
        return name;
    }

    public double getHourlyRate(){
        return rate;
    }

    public void rent(String customer){
        if(!is_rented){
            rentedBy = customer;
            is_rented = true;
        } else{
            throw new IllegalStateException("vehicle is already rented");
        }
    }

    public String getRentedBy(){
        return rentedBy;
    }

    public boolean isRented(){
        return is_rented;
    }

    public String getDescription(){
        return ("vehicle name: " + name + " rate: "+ rate);
    }

    public abstract String getActivity();
    public static void main(String[] args) {}

    
}