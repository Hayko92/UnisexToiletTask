public class Main {
    public static void main(String[] args) {
        Toilet toilet = new Toilet();
        MensQueue mensQueue1 = new MensQueue(toilet);
        MensQueue mensQueue2 = new MensQueue(toilet);
        WomensQueue womensQueue1 = new WomensQueue(toilet);
        WomensQueue womensQueue2 = new WomensQueue(toilet);
        GettingOut gettingOut1 = new GettingOut(toilet);
        GettingOut gettingOut2 = new GettingOut(toilet);

        mensQueue1.start();
        womensQueue1.start();
        mensQueue2.start();
        womensQueue2.start();
        gettingOut1.start();
        gettingOut2.start();
    }
}
