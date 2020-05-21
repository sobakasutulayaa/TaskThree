import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1 || args.length > 3) throw new Exception("Enter arguments in this order:" +
                "1) con or win" +
                "2) input file name" +
                "3) output file name");
        if (args[0].equals("con")) {
            consoleStart(args);
        } else {
            if (args[0].equals("win")) {
                winStart(args);
            } else {
                throw new Exception("First argument is wrong.");
            }
        }
    }

    /**
     * если передали аргумент "win"
     */
    static void winStart(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrameMain(args).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * если передали аргумент "con"
     */
    static void consoleStart(String[] args) throws Exception {
        Queue<Integer> oldQueue = new LinkedList<>();
        QueueImplementation<Integer> myQueue = new QueueImplementation<>();
        Arguments arguments = new Arguments(args);
        int[] arrOfLines = arguments.readIntArrFromConsoleOrFile();

        convertIntArrToQueue(arrOfLines, oldQueue);
        convertIntArrToQueueImplementation(arrOfLines, myQueue);

        System.out.println("------------");
        System.out.println("Origin Queue: ");
        Task.printJavaQueue(oldQueue);
        System.out.println("in QueueImplementation: ");
        Task.printQueueImplementation(myQueue);
        System.out.println("------------");

        QueueImplementation<Integer> newMyQueue = Task.swapPairedElementsBasedOnQueueImplementation(myQueue);
        Queue<Integer> newQueue = Task.swapPairedElementsBasedOnJavaQueue(oldQueue);

        System.out.println("New Queue: ");
        Task.printJavaQueue(newQueue);
        System.out.println("in QueueImplementation: ");
        Task.printQueueImplementation(newMyQueue);
        System.out.println("------------");

        arguments.writeQueueToFile(newQueue);
    }

    /**
     * Преобразует массив int в Queue
     */
    static void convertIntArrToQueue(int[] arr, Queue<Integer> queue) {
        for (int element : arr) {
            queue.add(element);
        }
    }

    /**
     * конвертирует массив в QueueImplementation
     */
    static void convertIntArrToQueueImplementation(int[] arr, QueueImplementation<Integer> queue) {
        for (int element : arr) {
            queue.add(element);
        }
    }
}