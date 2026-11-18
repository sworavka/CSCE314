import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> queue = new ArrayList<>();
        queue.add("Sam");
        queue.add("Maria");
        queue.add("Sam");

        System.out.println("Queue: ");
        for (String name : queue) {
            System.out.println(name);
        }
        HashSet<String> certifications = new HashSet<>();
        certifications.add("Laser");
        certifications.add("3D Printer");
        certifications.add("Laser");

        System.out.println();
        System.out.println("Certifications: ");

        for (String certificate : certifications) {
            System.out.println(certificate);
        }

        HashMap<String,String> equipment = new HashMap<>();

        equipment.put("EQ101", "Bambu Printer");
        equipment.put("EQ102", "Laser Cutter");

        System.out.println();
        System.out.println("EQ102: " + equipment.get("EQ102"));

        // add your name to the queue
        queue.add("Samantha");

        // add a certification
        certifications.add("Laser Cutter");

        // add an element to the map
        equipment.put("EQ103", "Trotec Laser Cutter");

        System.out.println();
        System.out.println("Queue: ");
        for (String name : queue) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println("Certifications: ");
        for (String certificate : certifications) {
            System.out.println(certificate);
        }

        System.out.println();
        System.out.println("Equipment: ");
        for (String key : equipment.keySet()) {
            System.out.println(key + ": " + equipment.get(key));
        }
    }
}