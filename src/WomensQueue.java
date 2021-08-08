public class WomensQueue extends Thread {
    private final Toilet toilet;

    public WomensQueue(Toilet toilet) {
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
            toilet.addWoman();
        }
    }
}
