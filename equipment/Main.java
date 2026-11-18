import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Equipment> equipment = new ArrayList<>();
        equipment.add(new Printer3D("Prusa"));
        equipment.add(new LaserCutter("Epilog"));
        System.out.println("MakerSpace Equipment");
        for  (Equipment item : equipment) {
            System.out.println(item.getName() + ": " + item.use());
        }
        Printer3D printer = new Printer3D("Bambu");
        Reservable reservableItem = printer;
        reservableItem.reserve("Robert");

        System.out.println();
        System.out.println(printer.getName() + " reserved by " + printer.getReservedBy());

        try {
            printer.reserve("Sam");
        } catch (IllegalStateException e) {
            System.out.println("Reservation failed " + e.getMessage());
        }
        StorageBox<Equipment> equipmentBox = new StorageBox<>();

        equipmentBox.store(new LaserCutter("Glowforge"));

        Equipment storedEquipment = equipmentBox.getItem();

        System.out.println();
        System.out.println("Stored equipment: " + storedEquipment.getName());

        // Assignment section
        printer.returnItem();
        printer.reserve("Samantha");
        System.out.println(printer.getName() + " reserved by " + printer.getReservedBy());
    }
}
