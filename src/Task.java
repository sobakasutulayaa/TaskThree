import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Task {

    public static Queue<Integer> swapPairedElementsBasedOnJavaQueue(Queue<Integer> oldQueue) {
        Queue<Integer> newQueue = new LinkedList<>();
        List<Integer> oldList = new LinkedList<>(oldQueue);

        int index = 1, count = 0, lastIndex = oldQueue.size() - 1;

        while (count < oldList.size() ) {
            count++;
            newQueue.add(oldList.get(index));

            if (oldList.size() % 2 != 0 && count == lastIndex) {
                newQueue.add(oldList.get(count));
                break;
            }

            if (index % 2 == 0) {
                index = index + 3;
            } else {
                index--;
            }
        }

        return newQueue;
    }

    public static QueueImplementation<Integer> swapPairedElementsBasedOnQueueImplementation
            (QueueImplementation<Integer> oldQueue) throws Exception {
        
        QueueImplementation<Integer> newQueue = new QueueImplementation<>();
        int index = 1, count = 0, lastIndex = oldQueue.size() - 1;

        while (count < oldQueue.size() ) {
            count++;
            newQueue.add(oldQueue.get(index));

            if (oldQueue.size() % 2 != 0 && count == lastIndex) {
                newQueue.add(oldQueue.get(count));
                break;
            }

            if (index % 2 == 0) {
                index = index + 3;
            } else {
                index--;
            }
        }

        return newQueue;
    }

    public static void printJavaQueue(Queue<Integer> queue) {
        int count = 1;

        for (Integer element : queue) {
            if (count < queue.size()) {
                System.out.print(element + ", ");
            } else {
                System.out.println(element + ".");
            }
            count++;
        }
    }
    public static void printQueueImplementation(QueueImplementation<Integer> queue) {
        int count = 1;

        for (Integer element : queue) {
            if (count < queue.size()) {
                System.out.print(element + ", ");
            } else {
                System.out.println(element + ".");
            }
            count++;
        }
    }
}