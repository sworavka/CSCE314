public class ThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        BackgroundTask backup =
            new BackgroundTask(
                "Backing up files"
            );

        BackgroundTask report =
            new BackgroundTask(
                "Generating report"
            );

        Thread t1 =
            new Thread(backup);

        Thread t2 =
            new Thread(report);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
            "Both tasks finished."
        );
    }
}
