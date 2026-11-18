public class Spinner {
    public static int spin(int sections){
        return (int)(Math.random()*sections+1);
    }
    public static String spin(String[] choices){
        return choices[(int)(Math.random()*choices.length)];    }

    public static void main(String[] args){
        int sections = 6;
        System.out.println("Spinning a spinner with " + sections + " sections: " + spin(sections));
        String[] choices = {"Red", "Blue", "Green", "Yellow"};
        System.out.println("Spinning a spinner with choices: " + spin(choices));
    }
}