import java.util.Scanner;

public class GameLibraryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
        System.out.println("CSCE 314 Game Library\n");
        System.out.println("1. Roll a die");
        System.out.println("2. Create a deck of cards");
        System.out.println("3. Create a domino set");
        System.out.println("4. Spin a spinner");
        System.out.println("5. Calculate a score");
        System.out.println("6. Start an hourglass timer");
        System.out.println("7. Exit\n");
        System.out.println("Choose an option: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("How many sides does the die have? ");
                int sides = scanner.nextInt();
                System.out.println("You rolled: " + Dice.roll(sides));
                break;
            case 2:
                String[] deck = Cards.createDeck();
                System.out.println(deck);
                break;
            case 3:
                System.out.println("Maximum domino value? ");
                int maxPips = scanner.nextInt();
                String[] dominoSet = Dominoes.createSet(maxPips);
                System.out.println(dominoSet);
                break;
            case 4:
                System.out.println("Spin a spinner with sections or choices? (Enter 'sections' or 'choices') ");
                String spinType = scanner.next();
                if (spinType.equalsIgnoreCase("choices")) {
                    System.out.println("Enter choices separated by commas: ");
                    scanner.nextLine(); // Consume the newline
                    String input = scanner.nextLine();
                    String[] choices = input.split(",");
                    System.out.println("You spun: " + Spinner.spin(choices));
                } else {
                System.out.println("How many sections? ");
                    int sections = scanner.nextInt();
                    System.out.println("You spun: " + Spinner.spin(sections));
                }
                break;
            case 5:
                int score = 0;
                System.out.println("Current score: " + score);
                System.out.println("Points earned: ");
                int points = scanner.nextInt();
                System.out.println("Multiplier (default 1): ");
                int multiplier = scanner.nextInt();
                if (multiplier == 0) {
                    multiplier = 1;
                }
                score = ScoreKeeper.addScore(score, points, multiplier);
                System.out.println("New score: " + score);
                break;
            case 6:
                System.out.println("Timer length in seconds: ");
                int seconds = scanner.nextInt();
                HourglassTimer.countdown(seconds);
                break;
            case 7:
                System.out.println("Exiting...");
                loop = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
