public class Dice {
    public static int roll(){
        return (int)(Math.random() * 6) + 1;
    }
    public static int roll(int sides){
        return (int)(Math.random() * sides) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Rolling a 6-sided die: " + roll());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Rolling a 12-sided die: " + roll(12));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Rolling a 20-sided die: " + roll(20));
        }
    }
}