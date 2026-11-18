import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class CollectionDemo {

    public static void main(String[] args) {

        ArrayList<String> queue =
            new ArrayList<>();

        queue.add("Sam");
        queue.add("Maria");
        queue.add("Sam");

        System.out.println("Queue:");
        for (String name : queue) {
            System.out.println(name);
        }


        HashSet<String> certifications =
            new HashSet<>();

        certifications.add("Laser");
        certifications.add("3D Printer");
        certifications.add("Laser");

        System.out.println();
        System.out.println("Certifications:");

        for (String certification : certifications) {
            System.out.println(certification);
        }


        HashMap<String, String> equipment =
            new HashMap<>();

        equipment.put("EQ101", "Bambu Printer");
        equipment.put("EQ102", "Laser Cutter");

        System.out.println();
        System.out.println(
            "EQ102: "
            + equipment.get("EQ102")
        );
    }
}
