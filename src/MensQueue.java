public class MensQueue extends Thread {
    private final Toilet toilet;

    public MensQueue(Toilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toilet.addMen();
        }
    }
}
