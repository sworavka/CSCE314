public class Dice {
    public static int roll(int sides) {
        return (int) (Math.random() * sides + 1);
    }

    public static int roll() {
        return roll(6);
    }
    public static void main(String[] args) {
    
   } 
}
