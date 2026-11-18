public class CostEstimator {
   public static double totalTripCost( double miles, double milesPerGallon, double pricePerGallon, double otherCosts){
       return(Fuel.fuelCost(miles, milesPerGallon, pricePerGallon) + otherCosts);
   }
  
}

