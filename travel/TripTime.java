public class TripTime {
   public static double hours(double miles, double milesPerHour){
       return( miles / milesPerHour);
   }
   public static double minutes(double miles, double milesPerHour){
       return(hours(miles, milesPerHour) * 60);
   }
}
