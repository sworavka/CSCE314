public class BackgroundTask
        implements Runnable {

    private String taskName;

    public BackgroundTask(
            String taskName) {

        this.taskName = taskName;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {

            System.out.println(
                taskName
                + " step "
                + i
            );
        }
    }

    public static void main(String[] args) {

        BackgroundTask task =
            new BackgroundTask(
                "Practice task"
            );

        task.run();
    }
}
