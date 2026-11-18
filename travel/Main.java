public class Main {
   public static void main(String[] args) {
   System.out.println(
       Distance.milesToKilometers(10.0));

   System.out.println(
       Fuel.gallonsNeeded(300.0, 30.0));

   System.out.println(
       TripTime.hours(150.0, 60.0));

   System.out.println(
       CostEstimator.totalTripCost(
           300.0, 30.0, 3.00, 50.0));
   }
}

class Distance{
   //might need to truncate numbers
   public static double milesToKilometers(double miles){
       return (miles * 1.60934);
   }
   public static double kilometersToMiles(double kilometers){
       return (kilometers * 0.621371);
   }
}

class Fuel{
   public static double gallonsNeeded(double miles, double milesPerGallon){
       return (miles / milesPerGallon);
   }
   public static double fuelCost( double miles, double milesPerGallon, double pricePerGallon){
       return(gallonsNeeded(miles, milesPerGallon) * pricePerGallon);
   }
}

