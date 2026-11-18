public class InputDemo {

    public static void main(String[] args) {

        String user;

        if (args.length > 0) {
            user = args[0];
        } else {
            user = "Guest";
        }

        System.out.println(
            "Welcome, " + user
        );
    }
}
