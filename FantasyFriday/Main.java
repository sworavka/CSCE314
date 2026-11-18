import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> party = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.println("Create party member " + (i + 1));
            System.out.print("Name: ");
            String characterName = scanner.nextLine();

            System.out.print("Weapon name: ");
            String weaponName = scanner.nextLine();

            System.out.print("Weapon die sides: ");
            int numWeaponDiceSides = scanner.nextInt();

            if (i == 3) {
                System.out.print("Magic power: ");
                int magicPower = scanner.nextInt();

                Weapon weapon = new Weapon(weaponName, numWeaponDiceSides);
                party.add(new Wizard(characterName, weapon, magicPower));
            } else {
                Weapon weapon = new Weapon(weaponName, numWeaponDiceSides);
                party.add(new Character(characterName, weapon));
            }

        
        }
        scanner.close();


        System.out.println("Your adventuring party: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(party.get(i).getDescription());
        }

        System.out.println("Attack rolls: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(party.get(i).getName() + " attacks for " + party.get(i).attack());
        }

        System.out.println(Character.getCharacterCount());

    }
}
