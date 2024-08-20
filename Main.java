//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue();
        circularQueue.add(0);
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.add(3);
        circularQueue.add(4);
        System.out.println(circularQueue);

        circularQueue.remove();
        circularQueue.remove();
        System.out.println(circularQueue);

    }
}