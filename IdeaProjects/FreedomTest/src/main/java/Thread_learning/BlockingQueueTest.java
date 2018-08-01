package Thread_learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static final int FILE_QUEUE_SIZE = 10;
    public static final int SEARCH_THREADS = 100;
    public static final File DUMMY = new File("");
    public static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter base diretory:");
            String directory = scanner.nextLine();
            System.out.println("Enter keyword:");
            String keyword = scanner.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            new Thread((enumerator)).start();
            for (int i = 0; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    private static void enumerate(File file) throws InterruptedException {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                enumerate(file1);
            } else {
                queue.put(file1);
            }
        }
    }

    public static void search(File file, String keyword) throws FileNotFoundException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextInt()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
