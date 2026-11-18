public class HourglassTimer {
    public static int validateTime(int seconds){
        if(seconds < 5){
            return 5;
        } else if(seconds > 60){
            return 60;
        } else {
            return seconds;
        }
    }
    public static void countdown(int seconds){
        seconds = validateTime(seconds);
        for(int i = seconds; i > 0; i--){
            System.out.println(i + " seconds remaining...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Time!");
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args){
        System.out.println(validateTime(10)); // Should print 10
        System.out.println(validateTime(3));  // Should print 5
        System.out.println(validateTime(70)); // Should print 60
        countdown(5); // Should count down from 5 seconds
        countdown(3); // Should count down from 5 seconds (minimum)
        countdown(65); // Should count down from 60 seconds (maximum)
    }
}
