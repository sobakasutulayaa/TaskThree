import java.util.LinkedList;
import java.util.Queue;


public class Task {

    public static Queue<Integer> swapPairedElementsBasedOnJavaQueue(Queue<Integer> oldQueue) {
        Queue<Integer> newQueue = new LinkedList<>();
        int deleteCounter = 0;

        while (deleteCounter < oldQueue.size() + deleteCounter) {

            if (oldQueue.size() % 2 == 1 && deleteCounter == oldQueue.size() + deleteCounter - 1) {
                int temp = oldQueue.poll();//return and delete element
                newQueue.add(temp);//add element
                deleteCounter++;
            } else {
                int temp1 = oldQueue.poll();
                int temp2 = oldQueue.poll();
                deleteCounter += 2;
                newQueue.add(temp2);
                newQueue.add(temp1);
            }
        }

        return newQueue;
    }

    public static QueueImplementation<Integer> swapPairedElementsBasedOnQueueImplementation
            (QueueImplementation<Integer> oldQueue) throws Exception {

        QueueImplementation<Integer> newQueue = new QueueImplementation<>();
        int deleteCounter = 0;

        while (deleteCounter < oldQueue.size() + deleteCounter) {

            if (oldQueue.size() % 2 == 1 && deleteCounter == oldQueue.size() + deleteCounter - 1) {
                int temp = oldQueue.dequeue(); //return and delete element
                newQueue.enqueue(temp); //add element
                deleteCounter++;
            } else {
                int temp1 = oldQueue.dequeue();
                int temp2 = oldQueue.dequeue();
                deleteCounter += 2;
                newQueue.enqueue(temp2);
                newQueue.enqueue(temp1);
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